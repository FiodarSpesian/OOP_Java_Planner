package view.plannerUI.commands.plannerMenu.chooseEvent;

import presenter.Presenter;
import view.View;
import view.plannerUI.commands.plannerMenu.WorkWithEvent;
import view.plannerUI.menu.Menu;

public class ChooseEvent extends Menu {
    WorkWithEvent command;
    public ChooseEvent(View view, Presenter presenter, WorkWithEvent command) {
        super(view, presenter);
        this.command = command;
        this.menu.add(new ChooseByDescription(this, this.command));
        this.menu.add(new ChooseByTime(this, this.command));
    }
}
