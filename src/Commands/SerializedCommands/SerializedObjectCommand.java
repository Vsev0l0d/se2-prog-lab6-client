package Commands.SerializedCommands;

import BasicClasses.StudyGroup;
import Commands.Command;

import java.io.Serializable;

public class SerializedObjectCommand implements Serializable {
    private Command command;
    private StudyGroup studyGroup;

    public SerializedObjectCommand(Command command) {
        this.command = command;
    }

    public void send() {

    }
}
