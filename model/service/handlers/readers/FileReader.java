package model.service.handlers.readers;

import model.planner.Writable;

public interface FileReader {
    Writable readFile(String fileName);
}
