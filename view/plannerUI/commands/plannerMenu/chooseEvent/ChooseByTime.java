package view.plannerUI.commands.plannerMenu.chooseEvent;

import view.plannerUI.commands.Command;
import view.plannerUI.commands.plannerMenu.PickEvent;
import view.plannerUI.commands.plannerMenu.WorkWithEvent;
import view.plannerUI.menu.Menu;

public class ChooseByTime extends Command {
    WorkWithEvent command;
    public ChooseByTime(Menu menu, WorkWithEvent command) {
        super("Выбрать по дате", menu);
        this.command = command;
    }

    @Override
    public void execute() {
        PickEvent event = new PickEvent(menu);
        event.execute();
        print("Выберите номер события:");
        int choice = this.scanner.nextInt();
        this.command.setEventIndex(choice - 1);
    }
}
