package view.plannerUI.commands.plannerMenu;

import view.plannerUI.commands.Command;
import view.plannerUI.menu.Menu;

public class SavePlanner extends Command {
    public SavePlanner(Menu menu) {
        super("Сохранить календарь", menu);
    }

    @Override
    public void execute() {
        print("Введите имя файла:\n");
        String fileName = this.scanner.nextLine();
        this.presenter.save(fileName);
    }
}
