package nio1;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Nio1Selector
 *
 * @author drebander
 * @since 2020-11-20 4:17 下午
 **/
public class NioSelector {
    Map<String, Channel> channelMap = new LinkedHashMap<>();
    /**
     * ThreadPoolExecutor:创建自定义线程池，池中保存的线程数为3，允许最大的线程数为6
     */

    ThreadPoolExecutor workThreadPool;

    public NioSelector() {
        this.channelMap = new LinkedHashMap<>();
        this.workThreadPool = new ThreadPoolExecutor(3, 6, 50, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
    }


    public void addChannel(Channel channel) {
        channelMap.put(channel.getId(), channel);
    }


    public void run() {
        while (true) {
            final Iterator<Channel> iterator = channelMap.values().iterator();
            while (iterator.hasNext()) {
                final Channel channel = iterator.next();
                ChannelHandler handler = new ChannelHandler(channel);
                workThreadPool.execute(handler);
                channelMap.remove(channel.getId());
            }
        }
    }

}
