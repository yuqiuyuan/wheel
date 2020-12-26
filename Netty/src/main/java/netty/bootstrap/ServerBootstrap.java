package netty.bootstrap;

import netty.channel.Channel;
import netty.channel.ChannelFuture;
import netty.channel.ChannelHandler;
import netty.channel.EventLoopGroup;

import java.net.SocketAddress;

/**
 * ServerBootstrap
 *
 * @author drebander
 * @since 2020-11-19 4:55 下午
 **/
public class ServerBootstrap<B, C> {

    ServerBootstrapConfig config = new ServerBootstrapConfig();
    ChannelHandler childHandler;

    public ServerBootstrap group(EventLoopGroup boss, EventLoopGroup work) {
        return null;
    }

    public EventLoopGroup group() {
        return null;
    }

    public B channel(Class channelClass) {
        return null;
    }

    public B option() {
        return null;
    }

    public ServerBootstrap childHandler(ChannelHandler childHandler) {
        return null;
    }

    public ChannelFuture bind(SocketAddress localAddress) {
        return null;
    }

    final ChannelFuture initAndRegister() {
        Channel channel = null;
        try {
        } catch (Exception e) {
        }
        ChannelFuture regFuture = this.config().group().register(channel);
        return regFuture;
    }

    ServerBootstrapConfig config() {
        return this.config;
    }


}
