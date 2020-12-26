package nio1;

/**
 * ChannelHandler
 *
 * @author drebander
 * @since 2020-11-20 4:24 下午
 **/
public class ChannelHandler implements Runnable {

    private Channel channel;

    public ChannelHandler(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {

    }
}
