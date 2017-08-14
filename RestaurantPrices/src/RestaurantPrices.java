import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class RestaurantPrices {

    public static void main(String[] args) {

        File foodList = new File("food.txt");
        File foodPrices = new File("Prices.txt");

        ArrayList<String> food = new ArrayList<String>();

        try {
            Scanner foodReader = new Scanner(foodList);

            while (foodReader.hasNextLine()) {
                food.add(foodReader.nextLine());
            }

        } catch (Exception e) {
            System.out.println("READING FAILURE");
        } finally {

            Scanner in = new Scanner(System.in);

            double[] prices = new double[food.size()];

            for (int i = 0; i < food.size(); i++) {
                System.out.printf("\nSpecify price for %s\n", food.get(i));
                prices[i] = in.nextDouble();
            }

            try {
                PrintWriter out = new PrintWriter(foodPrices);

                for (int i = 0; i < prices.length; i++) {
                    out.printf("%s: %5.2f$\t", food.get(i), prices[i] );
                }

                out.close();


            } catch (Exception e) {
                System.out.println("WRITING FAILURE");
            }





        }



    }
}
