package xyz.lijiantao.study.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Jiantao Li
 * @date 2020/3/12 17:14
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        Selector serverSelector = Selector.open();
        Selector clientSelector = Selector.open();
        new Thread(() -> {
            try {
                //服务端启动
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.socket().bind(new InetSocketAddress(8080));
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.register(serverSelector, SelectionKey.OP_ACCEPT);
                while (true){
                    //监测是否有新的连接，1指阻塞时间单位为ms
                    if(serverSelector.select(1) > 0){
                        Set<SelectionKey> set = serverSelector.selectedKeys();
                        Iterator<SelectionKey> iterator = set.iterator();
                        while (iterator.hasNext()){
                            SelectionKey key = iterator.next();
                            if(key.isAcceptable()){
                                try{
                                    //每来一个连接不创建新线程而是注册到clientSelector
                                    SocketChannel clientChannel = ((ServerSocketChannel)key.channel()).accept();
                                    clientChannel.configureBlocking(false);
                                    clientChannel.register(clientSelector,SelectionKey.OP_READ);
                                }finally {
                                    iterator.remove();
                                }

                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(()->{
            while (true){
                try {
                    //轮询哪些连接有数据可读，1指阻塞时间为1ms
                    if(clientSelector.select(1) > 0){
                        Set<SelectionKey> clientKeys = clientSelector.selectedKeys();
                        Iterator<SelectionKey> iterator = clientKeys.iterator();
                        while (iterator.hasNext()){
                            SelectionKey key = iterator.next();
                            if(key.isReadable()){
                                try{
                                    SocketChannel socketChannel = (SocketChannel) key.channel();
                                    //读取数据以字符块为单位
                                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                    socketChannel.read(byteBuffer);
                                    byteBuffer.flip();
                                    System.out.println(Charset.defaultCharset().newDecoder().decode(byteBuffer).toString());
                                }finally {
                                    iterator.remove();
                                    key.interestOps(SelectionKey.OP_READ);
                                }

                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
