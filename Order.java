class Order {
    private String productName;
    private String productDescription;
    private double productPrice;
    private int orderID = 0;


    Order(Product product, int orderID){
        this.productName = product.getProductName();
        this.productDescription = product.getProductDescription();
        this.productPrice = product.getProductPrice();
        this.orderID = orderID;
    }

    public void displayOrderDetails(){
        System.out.println("Order ID: " + orderID);
        System.out.println("Product name: " + productName);
        System.out.println("Price: ₱" + productPrice);
        System.out.println("Description: " + productDescription);
    }

    public int getOrderID() {
        return orderID;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }
}