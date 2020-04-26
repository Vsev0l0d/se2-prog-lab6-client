package Client;

import Commands.SerializedCommands.SerializedArgumentCommand;
import Commands.SerializedCommands.SerializedObjectCommand;
import Commands.SerializedCommands.SerializedSimplyCommand;

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
    }   // Отправка SerializedObjectCommand.

    public void sendObject(SerializedArgumentCommand serializedArgumentCommand) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(serializedArgumentCommand);
        byte [] data = bos.toByteArray();
        socketChannel.write(ByteBuffer.wrap(data));
    }   // Отправка SerializedArgumentCommand.

    public void sendObject(SerializedSimplyCommand serializedSimplyCommand) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(serializedSimplyCommand);
        byte [] data = bos.toByteArray();
        socketChannel.write(ByteBuffer.wrap(data));
    }   // Отправка SerializedSimplyCommand.
}
