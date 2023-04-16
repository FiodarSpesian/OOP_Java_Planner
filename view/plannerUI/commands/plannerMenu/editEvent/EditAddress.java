package view.plannerUI.commands.plannerMenu.editEvent;

import view.plannerUI.commands.Command;
import view.plannerUI.menu.Menu;

public class EditAddress extends EditCommand {
    public EditAddress(Menu menu, int eventIndex) {
        super("Редактировать адрес", menu, eventIndex);
    }

    @Override
    public void execute() {
        print("Введите новый адрес события:\n");
        String eventAddress = this.scanner.nextLine();
        boolean result = this.presenter.editEventAddress(this.eventIndex, eventAddress);
        if (result) {
            print("Событие успешно отредактировано");
        } else {
            print("Данное событие не найдено");
        }
    }
}
