public class Main {
    public static void main(String[] args) {

        //To do:
        //1. Add menu and interface

        //First create login page to ask what type of user (Seller or customer)
        //If seller is chosen go to seller page (create interface here)
        //If customer is chosen go to customer page (Create interface here)

        //Create menu for both seller and customer

        //Seller
        //Create menu for class methods:
        //seller.viewCatalogue();
        //seller.addProduct();
        //seller.displayAccountInfo(); - create in seller class
        //seller.updateAccountInfo() - create in seller class

        //Check viewCatalogue() and create menu and interface

        //Make sure to prompt user to get seller info before creating account

        Seller seller = new Seller();
        System.out.println("\nSELLER VIEW");
        seller.addProduct();

        seller.viewCatalogue();

        //Customer
        //Create menu for class methods:
        //customer.viewShoppingCart();
        //customer.placeOrder();
        //customer.viewCatalogue();
        //customer.displayAccountInfo(); - create in customer class
        //customer.updateAccountInfo(); - create in customer class


        //Check viewShoppingCart() and create menu and interface

        //Make sure to prompt user to get customer info before creating account

        Customer customer = new Customer();
        System.out.println("\nCUSTOMER VIEW");


        customer.placeOrder();
        customer.viewShoppingCart();


        //2. Also add exceptions to make sure user enters correct input in prompts: use exception handling

        //3. Add way to restrict customer from adding product to orders/orderlist if it is out of stock

        //4. Add way to decrease stock if product has been placed to order and is checkedout

        //- See program to understand logic or tanong niyo nalang ako HAHA
        //- Add methods and polish niyo nalang yung code if kailangan pero okay na naman yung mga methods









    }
}