package view.plannerUI.commands;

import view.plannerUI.menu.Menu;

public class Exit extends Command {
    public Exit(Menu menu) {
        super("Завершить работу", menu);
    }

    /**
     * Changes the program status to stop working
     */
    @Override
    public void execute() {
        this.menu.getView().setStatus(false);
    }
}
