package model.service;

import model.event.Event;
import model.planner.Planner;
import model.service.handlers.readers.OutputReader;
import model.service.handlers.writers.OutputWriter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;

public class Service {
    Planner planner;
    HashMap<Integer, Event> events;

    /**
     * Creates new planner
     */
    public void createNewPlanner() {
        this.planner = new Planner();
    }

    public void setPlanner(Planner planner) {
        this.planner = planner;
    }

    /**
     * Creates new event and adds it to the planner
     *
     * @param eventDescription event's description
     * @param eventDate        event's date
     * @param eventTime        event's time
     * @param eventAddress     event's address
     */
    public void createNewEvent(String eventDescription, String eventDate, String eventTime, String eventAddress) {
        if (this.planner != null) {
            Event event = new Event(eventDescription);
            LocalDateTime dateTime = parseDateTime(eventDate, eventTime);
            if (dateTime != null) {
                event.setDateTime(dateTime);
            }
            if (!eventAddress.isBlank()) {
                eventAddress = eventAddress.trim().replace("/", ",").replace(":", ",");
                while (eventAddress.contains(",,")) {
                    eventAddress = eventAddress.replace(",,", ",");
                }
                while (eventAddress.contains("..")) {
                    eventAddress = eventAddress.replace("..", ".");
                }
                event.setAddress(eventAddress);
            }
            this.planner.add(event);
        }
    }

    /**
     * Loads saved file and sets loaded object as this planner
     *
     * @param fileName string value of the file name
     */
    public void load(String fileName) {
        OutputReader reader = new OutputReader();
        this.planner = (Planner) reader.readFile(fileName);
    }

    /**
     * Saves the planner
     *
     * @param fileName string value of the file name
     */
    public void save(String fileName) {
        OutputWriter writer = new OutputWriter();
        writer.saveFile(fileName, this.planner);
    }

    /**
     * Finds event by given name and returns a HashMap with integer keys and event values and sets it as the field
     * of this class
     *
     * @param eventName string value of the event description
     * @return a HashMap with integer keys and event values
     */
    public HashMap<Integer, Event> findEventByName(String eventName) {
        this.events = new HashMap<>();
        for (Event event : this.planner.getEventList()) {
            if (event.getDescription().contains(eventName)) {
                this.events.put(this.planner.getEventList().indexOf(event), event);
            }
        }
        return this.events;
    }

    /**
     * Finds events in given period and returns a HashMap with integer keys and event values and sets it as the field
     * of this class
     *
     * @param startDate string value of the start date to look
     * @param endDate   string value of the end date to look
     * @return a HashMap with integer keys and event values
     */
    public HashMap<Integer, Event> pickEventByDate(String startDate, String endDate) {
        this.events = new HashMap<>();
        LocalDateTime startDateTime = parseDateTime(startDate, "00:00");
        LocalDateTime endDateTime = parseDateTime(endDate, "23:59");
        if (startDateTime != null && endDateTime != null) {
            for (Event event : this.planner.getEventList()) {
                if (event.getDateTime().isAfter(startDateTime) && event.getDateTime().isBefore(endDateTime)) {
                    this.events.put(this.planner.getEventList().indexOf(event), event);
                }
            }
        }
        return this.events;
    }

    /**
     * Deletes specified event
     *
     * @param key integer value of the event saved as the key of this event in this service's HashMap
     * @return true if the event successfully deleted, otherwise - false
     */
    public boolean delete(int key) {
        if (this.events.containsKey(key)) {
            Event event = this.events.get(key);
            this.planner.getEventList().remove(event);
            return true;
        }
        return false;
    }

    /**
     * Edits a description of the event
     *
     * @param key         integer value of the event saved as the key of this event in this service's HashMap
     * @param description new string value of the description to be assigned
     * @return true if the event successfully edited, otherwise - false
     */
    public boolean editEventDescription(int key, String description) {
        if (this.events.containsKey(key)) {
            Event event = this.events.get(key);
            event.setDescription(description);
            return true;
        }
        return false;
    }

    /**
     * Edits a date of the event
     *
     * @param key  integer value of the event saved as the key of this event in this service's HashMap
     * @param date new string value of the date to be assigned
     * @param time new string value of the time to be assigned
     * @return true if the event successfully edited, otherwise - false
     */
    public boolean editEventDate(int key, String date, String time) {
        if (this.events.containsKey(key)) {
            Event event = this.events.get(key);
            LocalDateTime dateTime = parseDateTime(date, time);
            if (dateTime != null) {
                event.setDateTime(dateTime);
                return true;
            }
        }
        return false;
    }

    /**
     * Edits a description of the event
     *
     * @param key     integer value of the event saved as the key of this event in this service's HashMap
     * @param address new string value of the address to be assigned
     * @return true if the event successfully edited, otherwise - false
     */
    public boolean editEventAddress(int key, String address) {
        if (this.events.containsKey(key)) {
            Event event = this.events.get(key);
            address = address.trim().replace("/", ",").replace(":", ",");
            while (address.contains(",,")) {
                address = address.replace(",,", ",");
            }
            while (address.contains("..")) {
                address = address.replace("..", ".");
            }
            event.setAddress(address);
            return true;
        }
        return false;
    }

    /**
     * Private method being used for parsing a date and time string values into LocalDateTime object
     *
     * @param date string value of the date
     * @param time string value of the time
     * @return LocalDateTime object
     */
    private LocalDateTime parseDateTime(String date, String time) {
        if (!date.isBlank()) {
            date = date.trim().replace("/", ".").replace(",", ".")
                    .replace(":", ".");
            while (date.contains("..")) {
                date = date.replace("..", ".");
            }
            if (!time.isBlank()) {
                time = time.trim().replace("/", ":").replace(",", ":")
                        .replace(".", ":");
                while (time.contains("::")) {
                    time = time.replace("::", ":");
                }
            } else {
                time = "00:00";
            }
            String dateTime = String.format("%s %s", date, time);
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
                return LocalDateTime.parse(dateTime, formatter);
            } catch (DateTimeParseException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
