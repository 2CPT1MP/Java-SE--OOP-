public class HouseExt {

    //Instance Variables
    private double height, width;
    private double sideHeight, sideWidth;

    private double windowsHeight, windowsWidth;
    private double doorsHeight, doorsWidth;

    private double rawArea, sideRawArea;
    private double windowsArea, doorsArea;

    private double finalArea;
    private int doorsCount, windowsCount;


    //Behavior
    public double getFinalArea() {
        return finalArea;
    }

    //Constructor
    public HouseExt(double[] input, int[] count) {
        height = input[0];
        width = input[1];

        sideHeight = input[2];
        sideWidth = input[3];

        doorsHeight = input[4];
        doorsWidth = input[5];

        windowsHeight = input[6];
        windowsWidth = input[7];

        doorsCount = count[0];
        windowsCount = count[1];

        sideRawArea = (sideHeight * sideWidth)*2;
        rawArea = ((height * width)*2) + sideRawArea;

        windowsArea = (windowsHeight * windowsWidth)*windowsCount;
        doorsArea = (doorsHeight * doorsWidth)* doorsCount;
        finalArea = rawArea - (windowsArea + doorsArea);

    }


}
