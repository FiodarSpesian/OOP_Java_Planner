package view.plannerUI.commands.plannerMenu.editEvent;

import view.plannerUI.menu.Menu;

public class EditDescription extends EditCommand {
    public EditDescription(Menu menu, int eventIndex) {
        super("Редактировать описание", menu, eventIndex);
    }

    @Override
    public void execute() {
        print("Введите новое описание события:\n");
        String eventDescription = this.scanner.nextLine();
        boolean result = this.presenter.editEventDescription(this.eventIndex, eventDescription);
        if (result) {
            print("Событие успешно отредактировано");
        } else {
            print("Данное событие не найдено");
        }
    }
}
