import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exitSystem = false;
        Seller seller = null;
        Customer customer = null;


        while (!exitSystem) {
            System.out.println();
            System.out.println("\n========== LOGGING IN ==========");
            System.out.print("Enter Email: ");
            String email = input.nextLine();
            System.out.print("Enter Password: ");
            String password = input.nextLine();

            System.out.println("\nLogged in Successfully!");


            boolean isLoggedIn = true;
            User.clear();

            if (isLoggedIn) {
                boolean exitRoleSelection = false;

                while (!exitRoleSelection) {
                    System.out.println("\n\n=========== SELECT A ROLE ==========");
                    System.out.println("[1] Seller");
                    System.out.println("[2] Customer");
                    System.out.println("[3] Exit");
                    System.out.println("=========== SELECT A ROLE ==========");
                    System.out.print("\nEnter choice: ");

                    try {
                        int role = input.nextInt();
                        input.nextLine();

                        switch (role) {
                            case 1:
                                User.clear();


                                if (seller == null) {
                                    seller = new Seller();
                                    seller = createSeller(seller, input, email, password);
                                }

                                seller.sellerMenu();
                                exitRoleSelection = true;
                                break;
                            case 2:
                                User.clear();

                                if (customer == null) {
                                    customer = new Customer();
                                    customer = createCustomer(customer, input, email, password);

                                }

                                customer.customerMenu();
                                exitRoleSelection = true;
                                break;
                            case 3:
                                exitRoleSelection = true;
                                exitSystem = true;
                                break;
                            default:
                                System.out.println("Invalid choice, please try again.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        exitRoleSelection = true;
                    }
                }
            } else {
                System.out.println("[Login failed. Please try again.]");
            }
        }
        input.close();
        System.out.println();
        System.out.println("System exited. Thank you for using the program!");
    }



    public static Seller createSeller(Seller seller, Scanner input, String email, String password) {

        if (seller.name == null && seller.address == null && seller.phoneNumber == null) {

            System.out.println("\n\n======== ENTER SELLER INFO ========");
            System.out.print("Enter Name: ");
            seller.setName(input.nextLine());

            System.out.print("Enter Address: ");
            seller.setAddress(input.nextLine());

            System.out.print("Enter Phone Number: ");
            seller.setPhoneNumber(input.nextLine());



        }
        seller.setEmail(email);
        seller.setPassword(password);

        System.out.println("\n[Account created successfully]");

        return seller;
    }

    public static Customer createCustomer(Customer customer, Scanner input, String email, String password) {



        if (customer.name == null && customer.address == null && customer.phoneNumber == null) {

            System.out.println("\n\n======== ENTER CUSTOMER INFO ========");
            System.out.print("Enter Name: ");
            customer.setName(input.nextLine());

            System.out.print("Enter Address: ");
            customer.setAddress(input.nextLine());

            System.out.print("Enter Phone Number: ");
            customer.setPhoneNumber(input.nextLine());


        }

            customer.setEmail(email);
            customer.setPassword(password);

            System.out.println("\n[Account created successfully]");

            return customer;

    }
}