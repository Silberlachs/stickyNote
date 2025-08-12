import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHandler {
    
    String filePath;

    public FileHandler(String filePath){
        this.filePath = filePath;
    }

    public void serializeNotes(ArrayList<String> notes){
        try {
            FileOutputStream fileOut = new FileOutputStream("noodle.soup");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(notes);
            out.close();
            fileOut.close();
        } catch (Exception fail) {
            System.out.println("writing notes failed");
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<String> loadNotes(){
        try {
            FileInputStream fileIn = new FileInputStream("noodle.soup");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            ArrayList<String> notes = (ArrayList<String>)in.readObject();

            in.close();
            fileIn.close();

            return notes;
        } catch (Exception fail) {
            System.out.println("loading notes failed");
            fail.printStackTrace();
        }
        return null;
    }

    public void serializeConfig(ConfigClass config){
        try {
            FileOutputStream fileOut = new FileOutputStream("noodle.bowl");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(config);
            out.close();
            fileOut.close();
        } catch (Exception fail) {
            System.out.println("writing config failed");
        }
    }

    public ConfigClass loadConfig(){
        try {
            FileInputStream fileIn = new FileInputStream("noodle.bowl");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            ConfigClass config = (ConfigClass)in.readObject();

            in.close();
            fileIn.close();

            return config;
        } catch (Exception fail) {
            System.out.println("loading config failed");
        }
        return null;
    }
}
