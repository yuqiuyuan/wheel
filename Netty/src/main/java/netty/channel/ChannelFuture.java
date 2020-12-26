package netty.channel;

import java.util.concurrent.Future;

public interface ChannelFuture extends Future<Void> {

    ChannelFuture sync() throws InterruptedException;

}
