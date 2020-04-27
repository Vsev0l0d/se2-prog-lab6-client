package Commands;

import BasicClasses.StudyGroup;
import Client.Sender;
import Commands.ConcreteCommands.*;
import Commands.SerializedCommands.SerializedArgumentCommand;
import Commands.SerializedCommands.SerializedCombinedCommand;
import Commands.SerializedCommands.SerializedObjectCommand;
import Commands.SerializedCommands.SerializedSimplyCommand;
import Commands.Utils.Creaters.ElementCreator;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Ресивер(получатель), отправляет серилизованные объекты на сервер.
 */
public class CommandReceiver {
    private final CommandInvoker commandInvoker;
    private final Sender sender;

    public CommandReceiver(CommandInvoker commandInvoker, Sender sender) {
        this.commandInvoker = commandInvoker;
        this.sender = sender;
    }

    public void help() {
        commandInvoker.getCommandMap().forEach((name, command) -> command.writeInfo());
    }

    public void info() throws IOException {
        sender.sendObject(new SerializedSimplyCommand(new Info()));
    }

    public void show() throws IOException {
        sender.sendObject(new SerializedSimplyCommand(new Show()));
    }

    public void add() throws IOException {
        sender.sendObject(new SerializedObjectCommand(new Add(), ElementCreator.createStudyGroup()));
    }

    /**
     *
     * @param ID - апдейт элемента по ID.
     */
    public void update(String ID) throws IOException {
        sender.sendObject(new SerializedCombinedCommand(new Update(), ElementCreator.createStudyGroup(), ID));
    }

    /**
     *
     * @param ID - удаление по ID.
     */
    public void removeById(String ID) throws IOException {
        sender.sendObject(new SerializedArgumentCommand(new RemoveByID(), ID));
    }

    public void clear() throws IOException {
        sender.sendObject(new SerializedSimplyCommand(new Clear()));
    }

    public void exit() {
        System.out.println("Завершение работы клиента.");
        System.exit(0);
    }

    public void head() throws IOException {
       sender.sendObject(new SerializedSimplyCommand(new Head()));
    }

    public void remove_greater() throws IOException {
        sender.sendObject(new SerializedObjectCommand(new RemoveGreater(), ElementCreator.createStudyGroup()));
    }

    public void remove_lower() throws IOException {
        sender.sendObject(new SerializedObjectCommand(new RemoveLower(), ElementCreator.createStudyGroup()));
    }

    public void min_by_semester_enum() throws IOException {
        sender.sendObject(new SerializedSimplyCommand(new MinBySemesterEnum()));
    }

    public void maxByGroupAdmin() throws IOException {
        sender.sendObject(new SerializedSimplyCommand(new MaxByGroupAdmin()));
    }

    public void countByGroupAdmin() throws IOException {
        sender.sendObject(new SerializedObjectCommand(new CountByGroupAdmin(), ElementCreator.createStudyGroup()));
    }

    public void executeScript(String path) {

    }
}
