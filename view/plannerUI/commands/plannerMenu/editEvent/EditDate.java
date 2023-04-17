package view.plannerUI.commands.plannerMenu.editEvent;

import view.plannerUI.commands.Command;
import view.plannerUI.menu.Menu;

public class EditDate extends EditCommand {
    public EditDate(Menu menu, int eventIndex) {
        super("Редактировать дату", menu, eventIndex);
    }

    @Override
    public void execute() {
        print("Введите дату в формате \"dd.MM.yyyy\":\n");
        String eventDate = this.scanner.nextLine();
        print("Введите время в формате \"HH:mm\":\n");
        String eventTime = this.scanner.nextLine();
        boolean result = this.presenter.editEventDate(this.eventIndex, eventDate, eventTime);
        if (result) {
            print("Событие успешно отредактировано");
        } else {
            print("Данное событие не найдено");
        }
    }
}
