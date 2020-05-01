package Commands;

import BasicClasses.StudyGroup;
import Client.Receiver;
import Client.Sender;
import Commands.ConcreteCommands.*;
import Commands.SerializedCommands.SerializedArgumentCommand;
import Commands.SerializedCommands.SerializedCombinedCommand;
import Commands.SerializedCommands.SerializedObjectCommand;
import Commands.SerializedCommands.SerializedSimplyCommand;
import Commands.Utils.Creaters.ElementCreator;

import java.io.*;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Ресивер(получатель), отправляет серилизованные объекты на сервер.
 */
public class CommandReceiver {
    private final CommandInvoker commandInvoker;
    private final Sender sender;
    private final SocketChannel socketChannel;

    public CommandReceiver(CommandInvoker commandInvoker, Sender sender, SocketChannel socketChannel) {
        this.commandInvoker = commandInvoker;
        this.sender = sender;
        this.socketChannel = socketChannel;
    }

    public void help() {
        commandInvoker.getCommandMap().forEach((name, command) -> command.writeInfo());
    }

    public void info() throws IOException, ClassNotFoundException, InterruptedException {
        sender.sendObject(new SerializedSimplyCommand(new Info()));
        Thread.sleep(50);
        Receiver.receive(socketChannel);
    }

    public void show() throws IOException, ClassNotFoundException, InterruptedException {
        sender.sendObject(new SerializedSimplyCommand(new Show()));
        Thread.sleep(50);
        Receiver.receive(socketChannel);
    }

    public void add() throws IOException, InterruptedException, ClassNotFoundException {
        sender.sendObject(new SerializedObjectCommand(new Add(), ElementCreator.createStudyGroup()));
        Thread.sleep(50);
        Receiver.receive(socketChannel);
    }

    /**
     *
     * @param ID - апдейт элемента по ID.
     */
    public void update(String ID) throws IOException, InterruptedException, ClassNotFoundException {
        sender.sendObject(new SerializedCombinedCommand(new Update(), ElementCreator.createStudyGroup(), ID));
        Thread.sleep(50);
        Receiver.receive(socketChannel);
    }

    /**
     *
     * @param ID - удаление по ID.
     */
    public void removeById(String ID) throws IOException, InterruptedException, ClassNotFoundException {
        sender.sendObject(new SerializedArgumentCommand(new RemoveByID(), ID));
        Thread.sleep(50);
        Receiver.receive(socketChannel);
    }

    public void clear() throws IOException, InterruptedException, ClassNotFoundException {
        sender.sendObject(new SerializedSimplyCommand(new Clear()));

        Thread.sleep(50);
        Receiver.receive(socketChannel);
    }

    public void exit() {
        System.out.println("Завершение работы клиента.");
        System.exit(0);
    }

    public void head() throws IOException, InterruptedException, ClassNotFoundException {
       sender.sendObject(new SerializedSimplyCommand(new Head()));

        Thread.sleep(50);
        Receiver.receive(socketChannel);
    }

    public void remove_greater() throws IOException, InterruptedException, ClassNotFoundException {
        sender.sendObject(new SerializedObjectCommand(new RemoveGreater(), ElementCreator.createStudyGroup()));

        Thread.sleep(50);
        Receiver.receive(socketChannel);
    }

    public void remove_lower() throws IOException, ClassNotFoundException, InterruptedException {
        sender.sendObject(new SerializedObjectCommand(new RemoveLower(), ElementCreator.createStudyGroup()));

        Thread.sleep(50);
        Receiver.receive(socketChannel);
    }

    public void min_by_semester_enum() throws IOException, InterruptedException, ClassNotFoundException {
        sender.sendObject(new SerializedSimplyCommand(new MinBySemesterEnum()));

        Thread.sleep(50);
        Receiver.receive(socketChannel);
    }

    public void maxByGroupAdmin() throws IOException, InterruptedException, ClassNotFoundException {
        sender.sendObject(new SerializedSimplyCommand(new MaxByGroupAdmin()));

        Thread.sleep(50);
        Receiver.receive(socketChannel);
    }

    public void countByGroupAdmin() throws IOException, InterruptedException, ClassNotFoundException {
        sender.sendObject(new SerializedObjectCommand(new CountByGroupAdmin(), ElementCreator.createStudyGroup()));

        Thread.sleep(50);
        Receiver.receive(socketChannel);
    }

    public void executeScript(String path) {

    }
}
