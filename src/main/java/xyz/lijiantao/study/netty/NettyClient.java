package xyz.lijiantao.study.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.util.concurrent.TimeUnit;

/**
 * @author Jiantao Li
 * @date 2020/3/12 23:21
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        bootstrap.group(nioEventLoopGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<Channel>() {
            @Override
            protected void initChannel(Channel channel) throws Exception {
                channel.pipeline().addLast(new StringEncoder());
            }
        });

        Channel channel = bootstrap.connect("192.168.3.135", 8080).channel();
        while (true) {
            channel.writeAndFlush(System.currentTimeMillis() + " : hello world");
//            Thread.sleep(5000);
            TimeUnit.SECONDS.sleep(5);
        }
    }
}
