package view.plannerUI.commands.plannerMenu.chooseEvent;

import view.plannerUI.commands.Command;
import view.plannerUI.commands.plannerMenu.FindEvent;
import view.plannerUI.commands.plannerMenu.WorkWithEvent;
import view.plannerUI.menu.Menu;

public class ChooseByDescription extends Command {
    WorkWithEvent command;
    public ChooseByDescription(Menu menu, WorkWithEvent command) {
        super("Выбрать по описанию", menu);
        this.command = command;
    }

    @Override
    public void execute() {
        FindEvent event = new FindEvent(menu);
        event.execute();
        print("Выберите номер события:");
        int choice = this.scanner.nextInt();
        this.command.setEventIndex(choice - 1);
    }
}
