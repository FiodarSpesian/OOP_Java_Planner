package presenter;

import model.event.Event;
import model.service.Service;
import view.View;

import java.util.HashMap;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void createNewPlanner() {
        this.service.createNewPlanner();
    }

    public void createNewEvent(String eventDescription, String eventDate, String eventTime, String eventAddress) {
        this.service.createNewEvent(eventDescription, eventDate, eventTime, eventAddress);
    }

    public void save(String filename) {
        this.service.save(filename);
    }

    public void load(String filename) {
        this.service.load(filename);
    }

    public HashMap<Integer, String> findEventByName(String eventName) {
        HashMap<Integer, Event> search = this.service.findEventByName(eventName);
        HashMap<Integer, String> results = new HashMap<>();
        for (Integer key : search.keySet()) {
            results.put(key, search.get(key).toString());
        }
        return results;
    }
    public HashMap<Integer, String> pickEventByDate(String startDate, String endDate) {
        HashMap<Integer, Event> search = this.service.pickEventByDate(startDate, endDate);
        HashMap<Integer, String> results = new HashMap<>();
        for (Integer key : search.keySet()) {
            results.put(key, search.get(key).toString());
        }
        return results;
    }

    public boolean editEventDescription(int choice, String description) {
        return this.service.editEventDescription(choice, description);
    }
    public boolean editEventDate(int choice, String date, String time) {
        return this.service.editEventDate(choice, date, time);
    }

    public boolean editEventAddress(int choice, String address) {
        return this.service.editEventAddress(choice, address);
    }


    public boolean deleteEvent(int choice) {
        return this.service.delete(choice);
    }

}
