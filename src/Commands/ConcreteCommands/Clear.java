package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;

import java.io.IOException;

/**
 * Конкретная команда очистки коллекции.
 */
public class Clear extends Command {
    private CommandReceiver commandReceiver;

    public Clear (CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    public Clear() {}

    @Override
    protected void execute(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Введен не нужный аргумент. Команда приведена к базовой команде clear.");
        }
        commandReceiver.clear();
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда clear – очистить коллекцию.");
    }
}
