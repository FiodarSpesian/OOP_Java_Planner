package model.service.handlers.writers;

import model.planner.Writable;

import javax.imageio.IIOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutputWriter implements FileWriter {
    String path;

    public OutputWriter() {
        this.path = "D:\\УЧЕБА\\Planner\\logs\\";
    }


    /**
     * Saves an object given in ObjectOutputStream
     *
     * @param fileName name of the file to be saved
     * @param object object to be saved
     */
    @Override
    public void saveFile(String fileName, Writable object) {
        if (object != null) {
            try {
                ObjectOutputStream fileSaver = new ObjectOutputStream(new FileOutputStream(String.format("%s%s.out",
                        this.path, fileName)));
                fileSaver.writeObject(object);
                fileSaver.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
