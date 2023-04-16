package view.plannerUI.commands.plannerMenu;

import view.plannerUI.commands.Command;
import view.plannerUI.menu.Menu;

public class AddEvent extends Command {
    public AddEvent(Menu menu) {
        super("Создать событие", menu);
    }

    @Override
    public void execute() {
        print("Введите описание события:\n");
        String eventDescription = this.scanner.nextLine();
        print("Введите дату в формате \"dd.MM.yyyy\":\n");
        String eventDate = this.scanner.nextLine();
        print("Введите время в формате \"HH:mm\":\n");
        String eventTime = this.scanner.nextLine();
        print("Введите адрес:\n");
        String eventAddress = this.scanner.nextLine();
        presenter.createNewEvent(eventDescription, eventDate, eventTime, eventAddress);
    }
}
