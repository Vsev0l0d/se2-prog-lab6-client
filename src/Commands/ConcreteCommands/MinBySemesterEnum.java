package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;

import java.io.IOException;

/**
 * Конкретная команда подсчета миниммального семестра.
 */
public class MinBySemesterEnum extends Command {
    private CommandReceiver commandReceiver;

    public MinBySemesterEnum(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    public MinBySemesterEnum(){}

    @Override
    protected void execute(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Введен не нужный аргумент. Команда приведена к базовой команде min_by_semester_enum.");
        }
        commandReceiver.min_by_semester_enum();
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда min_by_semester_enum – вывести любой объект из коллекции, значение поля semesterEnum которого является минимальным.");
    }
}
