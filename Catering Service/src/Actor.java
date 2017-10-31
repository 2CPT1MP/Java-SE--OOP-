public class Actor {
    public static void main(String[] args) {

        Event event1 = new Event("Wedding");
        System.out.println(event1);

        Event event2 = new Event("Birthday", "10/31/2017");
        System.out.println(event2);

        Event event3 = new Event("New Year", "12/31/2017", 10);
        System.out.println(event3);

    }
}
