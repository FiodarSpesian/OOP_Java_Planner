package view.plannerUI.commands.plannerMenu.editEvent;

import presenter.Presenter;
import view.View;
import view.plannerUI.menu.Menu;

public class EditData extends Menu {
    public EditData(View view, Presenter presenter, int indexEvent) {
        super(view, presenter);
        this.menu.add(new EditDescription(this, indexEvent));
        this.menu.add(new EditDate(this, indexEvent));
        this.menu.add(new EditAddress(this, indexEvent));
    }
}
