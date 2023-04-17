package model.service.handlers.writers;

import model.planner.Writable;

public interface FileWriter {
    void saveFile(String fileName, Writable object);
}
