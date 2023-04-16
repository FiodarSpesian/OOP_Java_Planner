package view.plannerUI.commands.plannerMenu;

import view.plannerUI.menu.Menu;

public class DeleteEvent extends WorkWithEvent {
    public DeleteEvent(Menu menu) {
        super("Удалить событие", menu);
    }

    @Override
    public void execute() {
        int menuChoice = this.choose();
        this.chooseEvent.run(menuChoice);
        boolean result = this.presenter.deleteEvent(this.eventIndex);
        if (result) {
            print("Событие успешно удалено");
        } else {
            print("Данное событие не найдено");
        }
    }
}
