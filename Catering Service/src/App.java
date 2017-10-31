import java.util.Scanner;
public class App {

    private static Scanner scanner;

    public static void main(String[] args) {
        scheduleEvent();
    }


    private static void scheduleEvent() {

        Event event = new Event();
        scanner = new Scanner(System.in);

        setEventName(event);
        setEventDate(event);
        setNumGuests(event);

        System.out.println("\nThe request has been processed successfully.\nYour Invoice:\n" + event);
    }

    private static void setEventName(Event e) {

        System.out.print("The Event name is ");
        e.setName(scanner.nextLine());
    }

    private static void setEventDate(Event e) {
        System.out.print("The event takes place on ");
        e.setDate(scanner.nextLine());
    }

    private static void setNumGuests(Event e) {
        System.out.print("The number of guests who are expected to arrive is ");
        e.setNumOfGuests(scanner.nextInt());
    }
}
