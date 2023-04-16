package view.plannerUI.commands.plannerMenu.editEvent;

import view.plannerUI.commands.Command;
import view.plannerUI.menu.Menu;

public abstract class EditCommand extends Command {
    int eventIndex;
    public EditCommand(String description, Menu menu, int eventIndex) {
        super(description, menu);
        this.eventIndex = eventIndex;
    }
}
