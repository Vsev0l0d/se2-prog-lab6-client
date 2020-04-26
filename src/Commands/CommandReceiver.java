package Commands;

import BasicClasses.StudyGroup;
import Client.Sender;
import Commands.ConcreteCommands.Add;
import Commands.ConcreteCommands.ExecuteScript;
import Commands.ConcreteCommands.Info;
import Commands.ConcreteCommands.RemoveByID;
import Commands.SerializedCommands.SerializedArgumentCommand;
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

    public void show() {
        //CollectionManager.show();
    }

    public void add() throws IOException {
        sender.sendObject(new SerializedObjectCommand(new Add(), ElementCreator.createStudyGroup()));
    }

    /**
     *
     * @param ID - апдейт элемента по ID.
     */
    public void update(String ID) {
        /*Integer groupId;
        try {
            groupId = Integer.parseInt(ID);
            if (CollectionUtils.checkExist(groupId)) { CollectionManager.update(ElementCreator.createStudyGroup(), groupId); }
            else {System.out.println("Элемента с таким ID нет в коллекции.");}
        } catch (NumberFormatException e) {
            System.out.println("Команда не выполнена. Вы ввели некорректный аргумент.");
        } */
    }

    /**
     *
     * @param ID - удаление по ID.
     */
    public void removeById(String ID) throws IOException {
        sender.sendObject(new SerializedArgumentCommand(new RemoveByID(), ID));
    }

    public void clear() {
        /*CollectionManager.clear();
        System.out.println("Коллекция успешно очищена.");*/
    }

    public void exit() {
        System.out.println("Завершение работы клиента.");
        System.exit(0);
    }

    public void head() {
       // CollectionManager.head();
    }

    public void remove_greater() {
        //CollectionManager.remove_greater(ElementCreator.createStudyGroup());
    }

    public void remove_lower() {
        //CollectionManager.remove_lower(ElementCreator.createStudyGroup());
    }

    public void min_by_semester_enum() {
        //CollectionManager.min_by_semester_enum();
    }

    public void maxByGroupAdmin() {
        //CollectionManager.maxByGroupAdmin();
    }

    public void countByGroupAdmin() {
        //CollectionManager.countByGroupAdmin(ElementCreator.createPerson());
    }

    public void executeScript(String path) {

    }
}
