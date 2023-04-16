package view.plannerUI.menu;

import presenter.Presenter;
import view.View;
import view.plannerUI.commands.Exit;
import view.plannerUI.commands.mainMenu.CreatePlanner;
import view.plannerUI.commands.mainMenu.LoadPlanner;

import java.util.ArrayList;

public class MainMenu extends Menu {

    public MainMenu(View view, Presenter presenter) {
        super(view, presenter);
        this.menu.add(new LoadPlanner(this));
        this.menu.add(new CreatePlanner(this));
        this.menu.add(new Exit(this));
    }
}
