package view.plannerUI.commands.plannerMenu;

import view.plannerUI.commands.Command;
import view.plannerUI.menu.MainMenu;
import view.plannerUI.menu.Menu;

public class ReturnToMain extends Command {
    public ReturnToMain(Menu menu) {
        super("Вернуться в главное меню", menu);
    }

    @Override
    public void execute() {
        this.menu.getView().start();
    }
}
