package view.plannerUI.menu;

import presenter.Presenter;
import view.View;
import view.plannerUI.commands.Command;

import java.util.ArrayList;

public abstract class Menu {
    protected ArrayList<Command> menu;
    protected View view;
    protected Presenter presenter;

    public Menu(View view, Presenter presenter) {
        this.view = view;
        this.presenter = presenter;
        this.menu = new ArrayList<>();
    }

    /**
     * running the command chosen by the user
     *
     * @param choice input value from console
     */
    public void run(int choice) {
        this.menu.get(choice - 1).execute();
    }

    @Override
    public String toString() {
        StringBuilder menuStringBuilder = new StringBuilder();
        for (Command command : this.menu) {
            menuStringBuilder.append(String.format("%d - %s\n", this.menu.indexOf(command) + 1, command.getDescription()));
        }
        return menuStringBuilder.toString();
    }

    public View getView() {
        return this.view;
    }

    public Presenter getPresenter() {
        return this.presenter;
    }
}
