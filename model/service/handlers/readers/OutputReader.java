package model.service.handlers.readers;

import model.planner.Writable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OutputReader implements FileReader {
    String path;

    public OutputReader() {
        this.path = "D:\\УЧЕБА\\Planner\\logs\\";
    }

    /**
     * Reads the file saved in ObjectOutputStream
     *
     * @param fileName name of the file saved before
     * @return saved object
     */
    @Override
    public Writable readFile(String fileName) {
        try {
            ObjectInputStream fileLoader = new ObjectInputStream(new FileInputStream(String.format("%s%s.out", this.path, fileName)));
            Writable object = (Writable) fileLoader.readObject();
            fileLoader.close();
            return object;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
