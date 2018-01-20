import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class OptionProcessor {


    private static OptionProcessor processor;
    public static OptionProcessor getInstance() {
        if (processor == null)
            processor = new OptionProcessor();
        return processor;
    }



    private ArrayList<String> options = new ArrayList<>();


    public void addOption(String option) {
        options.add(option);
        commitToSrc();
    }
    public String getOption() {
        readOptionsFromSrc();
        if (options.size() != 0)
            return options.get(randomizeOption());
        return "No options are available";
    }




    private void readOptionsFromSrc() {

       try (FileReader fileReader = new FileReader("options.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader)){

           while (true) {
               String line = bufferedReader.readLine();
               if (line == null)
                   return;
               options.add(line);
           }

       } catch (IOException e) {
           e.printStackTrace();
       }
         catch (Exception e) {
           e.printStackTrace();
         }
    }

    private void commitToSrc() {

        try (FileWriter fileWriter = new FileWriter("options.txt")) {

            Iterator<String> iterator = options.iterator();

            while (iterator.hasNext())
                fileWriter.write(iterator.next() + "\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

     private int randomizeOption() {
        Random randomizer = new Random();
        int randIndex = randomizer.nextInt(options.size());
        return randIndex;
    }
}
