package Client;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Receiver {
    public static void receive(SocketChannel socketChannel) throws IOException, ClassNotFoundException {
        byte[] data = new byte[1024];
        socketChannel.read(ByteBuffer.wrap(data));
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        System.out.println(objectInputStream.readObject());

        //Decrypting.decrypt(o);
    }
}
