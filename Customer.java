import java.util.ArrayList;
import java.util.Scanner;


public class Customer extends User  {
        Scanner input = new Scanner(System.in);

        private ArrayList <Order> orderList;
        private Product product;
        private Order order;
        private ShoppingCart shoppingCart;
        private int orderID;
        private int checkproductID = 1;



    Customer() {
        product = null;
        order = null;
        orderID = 0;
        shoppingCart = new ShoppingCart();
        orderList = new ArrayList<>();

    }



    //For customer to place order with the catalogue as reference
    public void placeOrder(){
        //Displays the catalogue
        catalogue.viewCatalogue();

        System.out.println("[Enter 0 to exit]\n");

        //Prompt to place an order
        System.out.println("PLACE ORDER");


        //Continues until 0 is entered for exit
        while(checkproductID != 0) {
            System.out.print("Enter product ID: ");
            checkproductID = input.nextInt();
            input.nextLine();


            //Checks if the product exists in the catalogue
            if (catalogue.checkCatalogue(checkproductID)) {

                //If product exist, return the product,
                product = catalogue.returnProduct(checkproductID);

                //set as order,
                orderID++;
                order = new Order(product, orderID);

                //add order to order list,
                orderList.add(order);

                //then transfer order list to shopping cart for processing
                shoppingCart.addCartItem(orderList);
                System.out.println("[Item added to cart]\n");


            } else if (checkproductID == 0){
                System.out.println("[Catalogue exited]");

            } else {

                System.out.println("[Product does not exist]\n");
            }
        }





    }

    //Displays shopping cart
    public void viewShoppingCart(){
        shoppingCart.viewCart();

        //Create menu for these class methods:

        //shoppingCart.removeCartItem();
        //shoppingCart.viewCart();
        //shoppingCart.checkOut();

        shoppingCart.checkOut();

    }

    //Manually display catalogue
    public void viewCatalogue(){
        catalogue.viewCatalogue();

    }




















}
