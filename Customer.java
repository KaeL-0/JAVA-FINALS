import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Customer extends User  {
    Scanner input = new Scanner(System.in);

    private ArrayList<Order> orderList;
    private Product product;
    private Order order;
    private ShoppingCart shoppingCart;
    private int orderID;
    private int checkproductID;


    Customer() {
        product = null;
        order = null;
        orderID = 0;
        shoppingCart = new ShoppingCart();
        orderList = new ArrayList<>();
        checkproductID = 1;

        this.name = null;
        this.address = null;
        this.phoneNumber = null;

    }



    //For customer to place order with the catalogue as reference
    public void placeOrder(){
        int productStock;

        //Displays the catalogue
        catalogue.viewCatalogue();

        System.out.println("[Enter '0' to exit]\n");

        //Prompt to place an order

        //Continues until 0 is entered for exit
        while(checkproductID != 0) {
            System.out.print("Enter product ID: ");
            checkproductID = input.nextInt();
            input.nextLine();


            //Checks if the product exists in the catalogue
            if (catalogue.checkCatalogue(checkproductID)) {

                //If product exist, return the product,
                product = catalogue.returnProduct(checkproductID);
                productStock = product.getProductStock();

                //Checks if product is in stock
                if (productStock > 0) {

                    //Reduce product stock
                    productStock--;
                    product.setProductStock(productStock);


                    //set as order,
                    orderID++;
                    order = new Order(product, orderID);

                    //add order to order list,
                    orderList.add(order);

                    //then transfer order list to shopping cart for processing
                    shoppingCart.addCartItem(orderList);
                    System.out.println("[Item added to cart]\n");

                } else {
                    System.out.println("[Product is out of stock]\n");

                }


            } else if (checkproductID == 0){
                System.out.println("[Catalogue exited]");

            } else {

                System.out.println("[Product does not exist]\n");
            }
        }
    }

    public void customerMenu() {
        boolean exitCustomerMenu = false;

        while (!exitCustomerMenu) {
            clear();
            System.out.println("\n\n========= CUSTOMER MENU =========");
            System.out.println("[1] View Shopping Cart");
            System.out.println("[2] Place Order");
            System.out.println("[3] Display Account");
            System.out.println("[4] Update Account Info");
            System.out.println("[5] Logout");
            System.out.println("[6] Exit");
            System.out.println("========= CUSTOMER MENU =========");

            System.out.print("\nEnter choice: ");

            try {
                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        clear();
                        viewShoppingCart();
                        break;
                    case 2:
                        clear();
                        System.out.println("\n\n====== PLACE ORDER ======\n");
                        placeOrder();
                        System.out.println();
                        pause();
                        break;
                    case 3:
                        clear();
                        System.out.println("\n\n====== ACCOUNT INFORMATION ======\n");
                        displayAccount();
                        break;
                    case 4:
                        clear();
                        System.out.println("\n\n=== UPDATE ACCOUNT INFORMATION ===");
                        updateAccountInfo();
                        break;
                    case 5:
                        clear();
                        exitCustomerMenu = true;
                        break;
                    case 6:
                        System.out.println("\nThank you for shopping with us!");
                        System.exit(0);
                    default:
                        System.out.println("[Invalid choice, please try again.]");
                }
            } catch (InputMismatchException e) {
                System.out.println("[Invalid input. Please enter a valid number.]");
                exitCustomerMenu = true;
            }
        }
    }

    //Displays shopping cart
    public void viewShoppingCart() {
        boolean exitCartMenu = false;

        while (!exitCartMenu) {
            clear();
            System.out.println("\n\n===== SHOPPING CART MENU =====");
            System.out.println("[1] View Orders");
            System.out.println("[2] Remove Cart Item");
            System.out.println("[3] Checkout");
            System.out.println("[4] Back to Customer Menu");
            System.out.println("===== SHOPPING CART MENU =====");

            System.out.print("\nEnter choice: ");

            try {
                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        clear();
                        System.out.println("\n\n====== SHOPPING CART ======\n");
                        shoppingCart.viewCart();
                        System.out.println();
                        pause();
                        break;
                    case 2:
                        clear();
                        System.out.println("\n\n====== REMOVE CART ITEM ======\n");


                        shoppingCart.removeCartItem();
                        System.out.println();
                        pause();
                        break;
                    case 3:
                        clear();
                        System.out.println("\n\n====== CHECKOUT ======\n");
                        shoppingCart.checkOut();
                        System.out.println();
                        pause();                          // temporary
                        break;
                    case 4:
                        exitCartMenu = true;
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                exitCartMenu = true;
            }
        }
    }





}