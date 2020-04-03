import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Main {
    public static void main(String[] args) {
        try {
            InetSocketAddress address = new InetSocketAddress("localhost", 4321);
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(address);
            System.out.println(socketChannel.finishConnect());
            for (int i = 0; i < 2; i++) {
                ByteBuffer writeBuffer = ByteBuffer.allocate(8192);
                writeBuffer.clear();
                writeBuffer.put("heartbeat".getBytes());

                writeBuffer.flip();
                while(writeBuffer.hasRemaining()) {
                    socketChannel.write(writeBuffer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}