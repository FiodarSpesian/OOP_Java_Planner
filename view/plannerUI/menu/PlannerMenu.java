package view.plannerUI.menu;

import presenter.Presenter;
import view.View;
import view.plannerUI.commands.Exit;
import view.plannerUI.commands.plannerMenu.*;
import view.plannerUI.commands.plannerMenu.ReturnToMain;

public class PlannerMenu extends Menu {

    public PlannerMenu(View view, Presenter presenter) {
        super(view, presenter);
        this.menu.add(new AddEvent(this));
        this.menu.add(new FindEvent(this));
        this.menu.add(new PickEvent(this));
        this.menu.add(new EditEvent(this));
        this.menu.add(new DeleteEvent(this));
        this.menu.add(new SavePlanner(this));
        this.menu.add(new ReturnToMain(this));
        this.menu.add(new Exit(this));
    }
}
