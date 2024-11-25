class Product  {

    private String productName;
    private double productPrice;
    private String productDescription;
    private int productStock;
    private int productID;


    Product (int productID){
        this.productID = productID;
        this.productName = "";
        this.productPrice = 0.0;
        this.productDescription = "";
        this.productStock = 0;
    }



    public void displayProduct(){
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + productName);
        System.out.println("Price: ₱" + productPrice);
        System.out.println("Description: " + productDescription);
        System.out.println("Stock: " + productStock);
    }


    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductDescription() {
        return productDescription;
    }
}