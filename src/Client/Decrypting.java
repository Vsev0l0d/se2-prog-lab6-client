package Client;

import Commands.SerializedCommands.*;

import java.io.IOException;

public class Decrypting {
    static void decrypt(Object o) throws IOException {
        if (o instanceof SerializedArgumentCommand) {
            SerializedArgumentCommand serializedArgumentCommand = (SerializedArgumentCommand) o;
            System.out.println(((SerializedArgumentCommand) o).getArg());
        }
    }
}
