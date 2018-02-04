package processing;
import java.util.Random;
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
        Source.addRecord(option);
    }

    public String getOption() {
        options = Source.download();
        if (options.size() != 0)
            return options.get(randomizeOption());
        return null;
    }

     private int randomizeOption() {
        Random randomizer = new Random();
        return randomizer.nextInt(options.size());
    }
}
