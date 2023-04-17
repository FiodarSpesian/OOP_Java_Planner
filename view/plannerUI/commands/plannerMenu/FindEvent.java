package view.plannerUI.commands.plannerMenu;

import view.plannerUI.commands.Command;
import view.plannerUI.menu.Menu;

import java.util.HashMap;

public class FindEvent extends Command {
    public FindEvent(Menu menu) {
        super("Найти событие по описанию", menu);
    }

    @Override
    public void execute() {
        print("Введите описание события:\n");
        String eventDescription = this.scanner.nextLine();
        HashMap<Integer, String> results = this.presenter.findEventByName(eventDescription);
        StringBuilder resultsStringBuilder = new StringBuilder();
        if (!results.isEmpty()) {
            for (Integer key : results.keySet()) {
                resultsStringBuilder.append(String.format("%d:\n%s\n", key + 1, results.get(key)));
            }
            print(resultsStringBuilder.toString());
        } else {
            print("Поиск не дал результатов");
        }
    }
}
