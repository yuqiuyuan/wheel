package netty.bootstrap;

import netty.channel.EventLoopGroup;

/**
 * ServerBootstrapConfig
 *
 * @author drebander
 * @since 2020-11-19 5:29 下午
 **/
public class ServerBootstrapConfig {
    protected ServerBootstrap bootstrap;

    public final EventLoopGroup group() {
        return this.bootstrap.group();
    }
}
