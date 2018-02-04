package processing;
import ui.Errors;
import java.io.*;
import java.util.ArrayList;

public abstract class Source {

    public static void addRecord(String record) {
        try (FileWriter fileWriter = new FileWriter("src.info", true))
         {
             BufferedWriter bf = new BufferedWriter(fileWriter);

             bf.write(record);
             bf.newLine();
             bf.flush();
        } catch (FileNotFoundException e) {
            Errors.showFileNotFoundError();
        } catch (IOException e) {
            Errors.showIOerror();
        }
    }

    public static void wipe() {
        File file = new File("src.info");
        file.delete();
    }

    public static ArrayList<String> download() {

        ArrayList<String> result = new ArrayList<>();

        try (FileReader fileReader = new FileReader("src.info");
             BufferedReader bufferedReader = new BufferedReader(fileReader)){

            while (true) {
                String line = bufferedReader.readLine();
                if (line == null)
                    return result;
                result.add(line);
            }
        } catch (IOException e) {}
          catch (Exception e) {}
        return result;
    }
}
