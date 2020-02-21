package discrete_event_simulation;

import java.io.FileWriter;
import java.io.IOException;

public class EventWriter {

    private FileWriter fileWriter;

    public EventWriter(String filename)  {
        try {
            fileWriter = new FileWriter(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String str) {
        try {
            fileWriter.write(str + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
