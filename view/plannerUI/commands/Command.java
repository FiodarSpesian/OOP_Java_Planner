package view.plannerUI.commands;

import presenter.Presenter;
import view.ConsoleUI;
import view.plannerUI.menu.Menu;

import java.util.Scanner;

public abstract class Command {
    protected String description;
    protected Menu menu;
    protected Presenter presenter;
    protected Scanner scanner;

    public Command(String description, Menu menu) {
        this.description = description;
        this.menu = menu;
        this.presenter = menu.getPresenter();
        this.scanner = new Scanner(System.in);
    }

    public abstract void execute();

    public String getDescription() {
        return this.description;
    }

    public void print(String text) {
        System.out.println(text);
    }
}
