package Client;

import Commands.SerializedCommands.SerializedObjectCommand;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Sender {
    private final Session session;
    private final SocketChannel socketChannel;

    public Sender(Session session) {
        this.session = session;
        this.socketChannel = session.getSocketChannel();
    }

    public void sendObject(SerializedObjectCommand serializedObjectCommand) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(serializedObjectCommand);
        byte [] data = bos.toByteArray();
        socketChannel.write(ByteBuffer.wrap(data));
    }
}
