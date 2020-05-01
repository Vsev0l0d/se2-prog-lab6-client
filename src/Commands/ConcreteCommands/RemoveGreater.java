package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;

import java.io.IOException;

/**
 * Конкретная команда удаления объектов, превышающих заданный.
 */
public class RemoveGreater extends Command {
    private CommandReceiver commandReceiver;

    public RemoveGreater (CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    public RemoveGreater() {}

    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 1) {
            System.out.println("Введен не нужный аргумент. Команда приведена к базовой команде remove_greater.");
        }
        commandReceiver.remove_greater();
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда remove_greater – удалить из коллекции все элементы, превышающие заданный.");
    }
}
