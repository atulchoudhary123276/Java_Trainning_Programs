package FunctionalPrograming.Assignment;
 class Customer {
    private String id;
    private String name;
    private String address;
    private ShoppingCart cart;
    public Customer(String id,String name, String address) {
        this.id=id;
        this.name = name;
        this.address = address;
        this.cart = new ShoppingCart();
    }
    public String getId(){
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public ShoppingCart getCart() {
        return cart;
    }

    public void addToCart(Product product) {
        cart.addProduct(product);
    }
    @Override
    public String toString() {
        return "Customer: " + name + " | Address: " + address;
    }
}
