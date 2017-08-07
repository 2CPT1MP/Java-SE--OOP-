import java.util.Random;
class Cart {

    //Attributes
    private String username, password;
    private int cartNumber;

    //Constructor
    Cart(String usern, String passw) {
        username = usern;
        password = passw;

        Random random = new Random();
        cartNumber = random.nextInt(1000000000);
    }




    //Behavior
    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    int getCardNumber() {
        return cartNumber;
    }

}
