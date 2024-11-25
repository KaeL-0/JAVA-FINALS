
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class ShoppingCart {
    private int cartID;

    private ArrayList<Order> orderList = new ArrayList<>();

    Payment payment;

    Scanner input = new Scanner(System.in);


    //Transfers passed order list to order list in the shopping cart
    public void addCartItem(ArrayList<Order> orderList) {
        this.orderList = orderList;

    }

    //Display shopping cart
    public void viewCart() {

        if (!orderList.isEmpty()) {
            for (Order order : orderList) {
                order.displayOrderDetails();
                System.out.println();
            }
        } else {
            System.out.println("[Shopping cart is empty]");
        }
    }

    //Removes order from shopping cart
    public void removeCartItem (){

        viewCart();

        if (!orderList.isEmpty()) {

            boolean orderExist = false;
            int orderToRemove;

            System.out.print("Enter order ID: ");
            orderToRemove = input.nextInt();
            input.nextLine();

            Iterator<Order> iter = orderList.iterator();

            while (iter.hasNext()) {
                Order order = iter.next();

                if (order.getOrderID() == orderToRemove) {
                    orderExist = true;

                    iter.remove();
                    System.out.println("\n[Order removed]");

                }
            }

            if (!orderExist) {
                System.out.println("\n[Order does not exist]");
            }

        }
    }

    public void checkOut(){

        if (!orderList.isEmpty()) {

            payment = new Payment();
            boolean confirm = false;



            while(!confirm) {

                //Display orders

                System.out.println("\nOrders: \n");

                for (Order order : orderList) {
                    order.displayOrderDetails();
                    System.out.println();
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


                    System.out.print("\nPrint receipt [Y/N]: ");
                    String receiptChoice = input.nextLine();

                    if (receiptChoice.equalsIgnoreCase("Y")){
                        printReceipt();
                    }





                }
            }

        } else {
            System.out.println("[Shopping cart is empty]");
        }
    }

    public void printReceipt(){
        try {
            FileWriter fileWriter = new FileWriter("receipt.txt");

            fileWriter.write("================================\n");
            fileWriter.write("            RECEIPT             \n");
            fileWriter.write("================================\n");




            for(Order order: orderList) {
                fileWriter.write("\nOrder " + order.getOrderID() + ": ");
                fileWriter.write(order.getProductName() + "\t\t");
                fileWriter.write("₱" + order.getProductPrice() + "\n");


            }

            fileWriter.write("\n================================\n");
            fileWriter.write("\nSubtotal: ₱" + payment.getSubtotal() + "\n");
            fileWriter.write("Shipping fee: ₱" + payment.getShippingFee() + "\n");
            fileWriter.write("Total: ₱" + payment.getTotal() + "\n");
            fileWriter.write("\n================================\n");


            fileWriter.write("\nShipping address: " + payment.getShippingAddress() + "\n");
            fileWriter.write("Payment method: " + payment.getPaymentMethod() + "\n");
            fileWriter.write("\n================================\n");

            fileWriter.write("\n           THANK YOU             \n");

            fileWriter.write("\n================================\n");
            fileWriter.write("\n         ║▌║█║▌│║▌║▌█");



            System.out.println("\n[Receipt created]\n");


            fileWriter.close();

            FileReader fileReader = new FileReader("receipt.txt");
            int x;

            while ((x = fileReader.read()) != -1) {
                System.out.print((char) x);

            }

        } catch (Exception exp){
            System.out.println(exp);
        }



    }
}