class CartCreator {

    Cart createCart(String username, String password) {

        Cart defaultCart = new Cart(username, password);

        //CartStorage.getInstance();
        return defaultCart;
    }

}
