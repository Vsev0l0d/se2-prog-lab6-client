import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;

public class Client implements Runnable {

    private SocketChannel socketChannel;
    private ByteBuffer outBuffer;
    private ByteBuffer inBuffer;
    private Selector selector;

    public Client() {
        outBuffer = ByteBuffer.allocate(512);
        inBuffer = ByteBuffer.allocate(2048);
    }


    private void connect() throws IOException {
        socketChannel = SocketChannel.open(new InetSocketAddress(4321));
        socketChannel.configureBlocking(false);
        selector = SelectorProvider.provider().openSelector();
    }

    private void sendData(String data) throws IOException {
        outBuffer.clear();
        outBuffer.put((data + "\n\r").getBytes());
        outBuffer.flip();
        while (outBuffer.hasRemaining()) {
            socketChannel.write(outBuffer);
        }
        socketChannel.register(selector, SelectionKey.OP_READ);

    }

    private String readData() throws IOException {
        inBuffer.clear();
        socketChannel.read(inBuffer);
        inBuffer.flip();
        socketChannel.register(selector, SelectionKey.OP_WRITE);

        return new String(inBuffer.array());
    }

    private void disconnect() throws IOException {
        socketChannel.close();
    }

    @Override
    public void run() {
        try {
            connect();
            while (!socketChannel.finishConnect()) {}
            while (socketChannel.isConnected()) {
                sendData("Эрик");
                Thread.sleep(20);
                System.out.println(readData() + "!");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}