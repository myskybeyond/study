package xyz.lijiantao.study.netty.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Jiantao Li
 * @date 2020/3/12 16:21
 */
public class IOServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        //接受新连接线程
        new Thread(() -> {
            while (true) {
                try {
//                    阻塞方法获取新的连接
                    Socket socket = serverSocket.accept();
//每个新的连接都创建一个线程，负责读取数据
                    new Thread(() -> {
                        byte[] data = new byte[1024];
                        try {
                            InputStream inputStream = socket.getInputStream();
                            while (true) {
                                int len;
                                while ((len = inputStream.read(data)) != -1) {
                                    System.out.println(new String(data, 0, len));
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
