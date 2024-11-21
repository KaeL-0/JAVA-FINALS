import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class ShoppingCart {
    private int cartID;

    private ArrayList<Order> orderList = new ArrayList<>();

    Payment payment;


    //Transfers passed order list to order list in the shopping cart
    public void addCartItem(ArrayList<Order> orderList) {
        this.orderList = orderList;

    }

    //Display shopping cart
    public void viewCart() {

        System.out.println("\nSHOPPING CART: ");

        if (!orderList.isEmpty()) {
            for (Order order : orderList) {
                order.displayOrderDetails();
            }
        } else {
            System.out.println("[Shopping cart is empty]");
        }


    }

    //Removes order from shopping cart
    public void removeCartItem (){
        Scanner input = new Scanner(System.in);

        boolean orderExist = false;
        int orderToRemove;

        System.out.println("REMOVE ORDER");
        System.out.print("Enter order ID: ");
        orderToRemove = input.nextInt();
        input.nextLine();

        Iterator <Order> iter = orderList.iterator();

        while(iter.hasNext()){
            Order order = iter.next();

            if (order.getOrderID() == orderToRemove){
                orderExist = true;

                iter.remove();
                System.out.println("\n[Order removed]");

            }
        }

        if (!orderExist){
            System.out.println("\n[Order does not exist]");
        }


    }



    public void checkOut(){


        if (!orderList.isEmpty()) {

            Scanner input = new Scanner(System.in);

            payment = new Payment();
            boolean confirm = false;

            while(!confirm) {
                System.out.println("\nCHECK OUT\n");


                //Display orders
                for (Order order : orderList) {
                    order.displayOrderDetails();
                }

                //Display total
                payment.calcTotal(orderList);

                //Choose payment method
                payment.choosePayment();

                //Get user address
                payment.takeAddress();



                //Confirm payment

                System.out.println("\nShipping address: " + payment.getShippingAddress());
                System.out.println("Payment method: " + payment.getPaymentMethod());

                System.out.print("\nConfirm [Y/N]: ");
                String choice = input.nextLine();

                if (choice.equalsIgnoreCase("Y")){
                    confirm = true;
                    System.out.println("\n[Checkout complete]");
                }

            }











        } else {
            System.out.println("[Shopping cart is empty]");
        }



    }




}