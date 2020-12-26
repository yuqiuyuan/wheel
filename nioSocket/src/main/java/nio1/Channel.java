package nio1;

import java.net.Socket;
import java.util.UUID;

/**
 * Channel
 *
 * @author drebander
 * @since 2020-11-20 4:18 下午
 **/
public class Channel {
    private String id;
    Socket socket;


    public String getId() {
        return id;
    }

    public Channel(Socket socket) {
        this.socket = socket;
        id = UUID.randomUUID().toString();
    }
}
