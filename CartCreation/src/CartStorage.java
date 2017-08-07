class CartStorage {

    private static CartStorage defaultCartStorage;

    private Cart[] storage = new Cart[5];

    private CartStorage(){}

    static CartStorage getInstance() {

        if (defaultCartStorage == null) {
            defaultCartStorage = new CartStorage();
        }

        return defaultCartStorage;
    }
}
