package view.plannerUI.commands.plannerMenu;

import view.plannerUI.commands.Command;
import view.plannerUI.menu.Menu;

import java.util.ArrayList;
import java.util.HashMap;

public class PickEvent extends Command {
    public PickEvent(Menu menu) {
        super("Найти событие по дате", menu);
    }

    @Override
    public void execute() {
        print("Введите начальную дату поиска в формате \"dd.MM.yyyy\":\n");
        String startDate = this.scanner.nextLine();
        print("Введите конечную дату поиска в формате \"dd.MM.yyyy\":\n");
        String endDate = this.scanner.nextLine();
        HashMap<Integer, String> results = this.presenter.pickEventByDate(startDate, endDate);
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
