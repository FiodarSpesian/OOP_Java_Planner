package view.plannerUI.commands.mainMenu;

import view.plannerUI.commands.Command;
import view.plannerUI.menu.Menu;

public class LoadPlanner extends Command {

    public LoadPlanner(Menu menu) {
        super("Загрузить календарь", menu);
    }

    @Override
    public void execute() {
        print("Введите имя файла:\n");
        String fileName = this.scanner.nextLine();
        this.presenter.load(fileName);
    }
}
