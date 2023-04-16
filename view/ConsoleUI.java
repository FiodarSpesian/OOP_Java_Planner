package view;

import presenter.Presenter;
import view.plannerUI.commands.plannerMenu.chooseEvent.ChooseEvent;
import view.plannerUI.menu.MainMenu;
import view.plannerUI.menu.Menu;
import view.plannerUI.menu.PlannerMenu;

import java.util.Scanner;

public class ConsoleUI implements View {
    protected Presenter presenter;
    protected Scanner scanner;
    protected boolean status;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.status = true;
    }

    /**
     * Starts the program
     */
    @Override
    public void start() {
        Menu mainMenu = new MainMenu(this, this.presenter);
        print(String.format("Выберите действие:\n%s", mainMenu.toString()));
        int mainChoice = this.scanner.nextInt();
        mainMenu.run(mainChoice);
        while (status) {
            Menu plannerMenu = new PlannerMenu(this, this.presenter);
            print(String.format("Выберите действие:\n%s", plannerMenu.toString()));
            int choice = this.scanner.nextInt();
            plannerMenu.run(choice);
        }
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Prints text in console
     *
     * @param text the string value to be printed
     */
    @Override
    public void print(String text) {
        System.out.println(text);
    }

    public boolean getStatus() {
        return this.status;
    }

    /**
     * Sets the status on the program (work, not work)
     *
     * @param status boolean value of the program status
     */
    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }
}
