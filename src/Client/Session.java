package Client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Session {
    private SocketChannel socketChannel;
    private String hostName;
    private int port;

    public Session(String hostName, int port) {
        this.hostName = hostName;
        this.port = port;
    }

    public void startSession() throws IOException {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(hostName, port);
        socketChannel = SocketChannel.open(inetSocketAddress);

        System.out.println(String.format("Подключение к удаленному адресу %s по порту %d", hostName, port));
    }

    SocketChannel getSocketChannel() {
        return socketChannel;
    }
}
