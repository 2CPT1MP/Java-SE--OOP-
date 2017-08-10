import java.util.Scanner;
public class AreaCalc {

    //Instance Variables
    private double[] tempM = new double[8];
    private int[] tempC = new int[2];
    private double gallonCov;

    Scanner scanner = new Scanner(System.in);

    //Behavior
    private void promptForHw() {
        System.out.println("Specify height and width for front of the house by separating measures with a space (eg 100.00 200.00)");
        tempM[0] = scanner.nextDouble();
        tempM[1] = scanner.nextDouble();
    }

    private void promptForSideHw() {
        System.out.println("\nSpecify height and width a side of the house by separating measures with a space (eg 70.00 95.00)");
        tempM[2] = scanner.nextDouble();
        tempM[3] = scanner.nextDouble();
    }

    private void promptForDoorHw() {
        System.out.println("\nSpecify height and width of a door by separating measures with a space (eg 10.00 15.00)");
        tempM[4] = scanner.nextDouble();
        tempM[5] = scanner.nextDouble();
    }

    private void promptForWindowHw() {
        System.out.println("\nSpecify height and width of a window by separating measures with a space (eg 5.00 7.00)");
        tempM[6] = scanner.nextDouble();
        tempM[7] = scanner.nextDouble();
    }

    private void promptForDoorsNum() {
        System.out.println("\nHow many doors does the house have?");
        tempC[0] = scanner.nextInt();
    }

    private void promptForWindowsNum() {
        System.out.println("\nHow many windows does the house have?");
        tempC[1] = scanner.nextInt();
    }

    private void promptForGallonCoverage() {
        System.out.println("\nHow much area does one gallon cover?");
        gallonCov = scanner.nextDouble();
    }

    private void getInfo() {
        promptForHw();
        promptForSideHw();
        promptForDoorHw();
        promptForWindowHw();
        promptForDoorsNum();
        promptForWindowsNum();
        promptForGallonCoverage();
    }

    private HouseExt buildHouse() {
        HouseExt houseExt = new HouseExt(tempM, tempC);
        return houseExt;
    }

    private double calcGallons(double area) {
        return area / gallonCov;
    }


    public static void main(String[] args) {

        AreaCalc areaCalc = new AreaCalc();
        //User user = new User();

        areaCalc.getInfo();
        HouseExt house = areaCalc.buildHouse();
        double area = house.getFinalArea();

        System.out.printf("Your total house area is %6.2f", area);
        System.out.println(" " +areaCalc.calcGallons(area) + " gallons needed");






    }
}
