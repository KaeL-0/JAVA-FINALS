import java.util.ArrayList;
import java.util.Scanner;

class Payment {
    Scanner input = new Scanner(System.in);

    private double subtotal;
    private double total;
    private double shippingFee;
    private String shippingAddress;
    private String paymentMethod;


    Payment (){
        subtotal = 0.0;
        total = 0.0;
        shippingFee = 100.0;
    }




    public void calcTotal (ArrayList<Order> orderList){
        //Calculate subtotal
        for (Order order : orderList){
            subtotal += order.getProductPrice();
        }

        total = subtotal + shippingFee;
        System.out.println("\nPayment Details: ");
        System.out.println("Subtotal: ₱" + subtotal);
        System.out.println("Shipping fee: ₱" + shippingFee);
        System.out.println("Total: ₱" + total);
    }

    public void choosePayment(){
        System.out.println("\nPayment Methods: ");
        System.out.println("[1] Cash on Delivery");
        System.out.println("[2] Debit Card/Credit Card");
        System.out.println("[3] Gcash");
        System.out.print("\nChoice: ");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice){

            case 1:
                paymentMethod = "Cash on Delivery";

                break;
            case 2:
                paymentMethod = "Debit Card/Credit Card";
                break;

            case 3:
                paymentMethod = "Gcash";
                break;

            default:
                System.out.println("Invalid input.");

        }

    }

    public void takeAddress(){
        System.out.print("\nEnter shipping address: ");
        shippingAddress = input.nextLine();
    }


    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public double getSubtotal(){
        return subtotal;

    }

    public double getTotal(){
        return total;

    }

    public double getShippingFee(){
        return shippingFee;
    }


}