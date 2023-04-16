package view.plannerUI.commands.mainMenu;

import view.plannerUI.commands.Command;
import view.plannerUI.menu.Menu;

public class CreatePlanner extends Command {
    public CreatePlanner(Menu menu) {
        super("Создать новый календарь", menu);
    }

    @Override
    public void execute() {
        this.presenter.createNewPlanner();
    }
}
