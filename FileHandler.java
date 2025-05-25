import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler {
    
    String filePath;

    public FileHandler(String filePath){
        this.filePath = filePath;
    }

    public void serializeNotes(String notes){
        try {
            FileOutputStream fileOut = new FileOutputStream("urmom.gay");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(notes);
            out.close();
            fileOut.close();
        } catch (Exception fail) {
            System.out.println("writing failed");
        }
    }

    public String loadNotes(){
        try {
            FileInputStream fileIn = new FileInputStream("urmom.gay");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            String kekw = (String)in.readObject();

            in.close();
            fileIn.close();

            return kekw;
        } catch (Exception fail) {
            System.out.println("loading failed");
        }
        return "failed loading";
    }
}
