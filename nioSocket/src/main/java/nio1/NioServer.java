package nio1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * NioServer
 *
 * @author drebander
 * @since 2020-11-20 4:33 下午
 **/
public class NioServer {
    public static void main(String[] args) throws IOException {
        NioSelector nio1Selector = new NioSelector();
        nio1Selector.run();
        ServerSocket socket = new ServerSocket(8080);
        while (true) {
            Socket s = socket.accept();
            nio1Selector.addChannel(new Channel(s));
        }
    }
}
