import model.service.Service;
import presenter.Presenter;
import view.ConsoleUI;
import view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        Service service = new Service();
        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}
