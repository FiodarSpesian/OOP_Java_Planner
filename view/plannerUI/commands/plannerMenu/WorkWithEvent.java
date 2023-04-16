package view.plannerUI.commands.plannerMenu;

import view.plannerUI.commands.Command;
import view.plannerUI.commands.plannerMenu.chooseEvent.ChooseEvent;
import view.plannerUI.commands.plannerMenu.editEvent.EditData;
import view.plannerUI.menu.Menu;

public abstract class WorkWithEvent extends Command {
    Menu chooseEvent;
    Menu editData;
    int eventIndex;

    public WorkWithEvent(String description, Menu menu) {
        super(description, menu);
        this.chooseEvent = new ChooseEvent(this.menu.getView(), this.presenter, this);
        this.editData = new EditData(this.menu.getView(), this.presenter, this.eventIndex);
    }

    /**
     * Runs the user interface to choose the event to handle
     *
     * @return integer value og the user choice
     */
    public int choose() {
        print(String.format("Выберите метод поиска:\n%s", chooseEvent.toString()));
        return this.scanner.nextInt();
    }

    /**
     * Runs the user interface to choose the field of the event to edit
     *
     * @return integer value og the user choice
     */
    public int edit() {
        print(String.format("Выберите параметр для редактирования:\n%s", editData.toString()));
        return this.scanner.nextInt();
    }

    public void setEventIndex(int eventIndex) {
        this.eventIndex = eventIndex;
    }
}
