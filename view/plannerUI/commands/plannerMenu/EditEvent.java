package view.plannerUI.commands.plannerMenu;

import view.plannerUI.menu.Menu;

public class EditEvent extends WorkWithEvent {
    public EditEvent(Menu menu) {
        super("Редактировать событие", menu);
    }

    @Override
    public void execute() {
        int menuChoice = this.choose();
        this.chooseEvent.run(menuChoice);
        int editChoice = this.edit();
        this.editData.run(editChoice);
    }
}
