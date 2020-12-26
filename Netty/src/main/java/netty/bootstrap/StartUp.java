package netty.bootstrap;

import netty.channel.EventLoopGroup;
import netty.channel.nio.NioEventLoopGroup;
import netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * StartUp
 *
 * @author drebander
 * @since 2020-11-19 4:57 下午
 **/
public class StartUp {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(workGroup, bossGroup);
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.childHandler(null);
        serverBootstrap.bind(new InetSocketAddress(13425)).sync();
    }
}
