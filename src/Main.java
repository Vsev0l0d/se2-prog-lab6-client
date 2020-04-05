import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

class Zalupa implements Serializable {
    public int size;

    public Zalupa(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    private void readObject(ObjectInputStream test)throws
            IOException, ClassNotFoundException
    {
        // Use of defaultReadObject() :
        test.defaultReadObject();
    }
}


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        InetSocketAddress crunchifyAddr = new InetSocketAddress("localhost", 4321);
        SocketChannel crunchifyClient = SocketChannel.open(crunchifyAddr);

        log("Connecting to Server on port 4321...");

        Zalupa zalupa = new Zalupa(5);
        System.out.println(zalupa.getSize());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(zalupa);
        byte [] data = bos.toByteArray();
        crunchifyClient.write(ByteBuffer.wrap(data)); //write

        crunchifyClient.close();
    }

    private static void log(String str) {
        System.out.println(str);
    }

}