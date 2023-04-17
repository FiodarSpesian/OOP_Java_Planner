package model.event;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event implements Serializable {
    private String description;
    private LocalDateTime dateTime;
    private String address;

    public Event(String description) {
        this.description = description;
    }

    /**
     * Sets new event description
     *
     * @param description string value of the event's description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets new LocalDateTime object as event's LocalDateTime
     *
     * @param dateTime LocalDateTime object to be set as event's LocalDateTime
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Sets new event address
     *
     * @param address string value of the event's address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns event's description
     *
     * @return string value of the event's description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns this event's LocalDateTime
     *
     * @return LocalDateTime assigned as event's LocalDateTime
     */
    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    /**
     * Returns event's address
     *
     * @return string value of the event's address
     */
    public String getAddress() {
        return this.address;
    }

    @Override
    public String toString() {
        StringBuilder eventStringBuilder = new StringBuilder();
        eventStringBuilder.append(this.description).append("\n");
        if (this.dateTime != null) {
            String dateTime = this.dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
            eventStringBuilder.append(dateTime).append("\n");
        }
        if (!this.address.isBlank()) {
            eventStringBuilder.append(this.address).append("\n");
        }
        return eventStringBuilder.toString();
    }
}
