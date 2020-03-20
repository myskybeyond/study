package xyz.lijiantao.study.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jiantao Li
 * @date 2020/3/13 11:06
 */
@Slf4j
public class NettyServerDemo {

    private static ChannelInitializer serverStartHandler;

    public static void main(String[] args) {
        NioEventLoopGroup boosGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boosGroup, workGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {

            }
        });
        serverBootstrap.handler(serverStartHandler);
        /**
         * 放参数
         */
        serverBootstrap.attr(AttributeKey.newInstance("arg1"),"arg1");
        serverBootstrap.bind(8080);
    }

    private class serverStartHandler extends ChannelInitializer<NioServerSocketChannel>{

        @Override
        protected void initChannel(NioServerSocketChannel nioServerSocketChannel) throws Exception {
            /**
             * 服务端启动时业务逻辑代码
             */
            log.debug("服务端启动时业务逻辑代码");
        }
    }
}
