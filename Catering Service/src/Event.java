import java.text.NumberFormat;
import java.util.Locale;

public class Event {

    //INSTANCE DATA
    private String name, date, id;
    private double costPerGuest;
    private int numOfGuests;
    private static int ID_SEED = 0;

    //ACCESSOR METHODS
    protected String getName() {return name;}
    protected String getDate() {return date;}
    protected String getId()   {return id;}
    protected double getCostPerGuest() {return costPerGuest;}
    protected int getNumOfGuests()   {return numOfGuests;}
    protected int getIdSeed() {return ID_SEED;}

    //MODIFIER METHODS
    protected void setName(String n) {
        name = n;
        setId(String.format("%c%04d", name.charAt(0), ID_SEED++).toUpperCase());
    }
    protected void setDate(String d) {date = d;}
    protected void setId(String i) {id = i;}
    protected void setCostPerGuest(double c) {costPerGuest = c;}
    protected void setNumOfGuests(int n) {numOfGuests = n;}
    protected void setIdSeed(int s) {ID_SEED = s;}


    //CONSTRUCTORS
    protected Event(String name, String date, int numOfGuests) {

        costPerGuest = 40.00d;
        this.name = name;
        this.date = date;
        this.numOfGuests = numOfGuests;
    }

    protected Event(String name) {
        this(name, "N/A", 0);
    }

    protected Event(String name, String date) {
        this (name, date, 0);
    }

    protected Event() {this ("N/A");}


    //BEHAVIOR
    public String toString() {
        return "\n\n==========================\nID: " +id + "\n==========================\nTitle: " + name + "\nDate: " + date + "\nPrice Per Guest: "
                + costPerGuest + "\nNumber of Guests: " + numOfGuests + "\n==========================\n        TOTAL: " +getFormattedTotal() + "\n\n\n";
    }

    private double getTotal() {return numOfGuests * costPerGuest;}
    private String getFormattedTotal() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(getTotal());
    }










}
