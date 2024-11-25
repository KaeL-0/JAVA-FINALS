import java.util.Scanner;

abstract class User {
    protected String name;
    protected String email;
    protected String password;
    protected String address;
    protected String phoneNumber;

    static Catalogue catalogue = new Catalogue();
    //Created static so catalogue will be shared among the seller and customer users

    public void displayAccount() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Password: " + password);
        System.out.println();
        pause();
    }

    Scanner input = new Scanner(System.in);

    public void updateAccountInfo() {

        System.out.print("Enter new name: ");
        this.name = input.nextLine();

        System.out.print("Enter new email: ");
        this.email = input.nextLine();

        System.out.print("Enter new address: ");
        this.address = input.nextLine();

        System.out.print("Enter new phone number: ");
        this.phoneNumber = input.nextLine();

        System.out.print("Enter new password: ");
        this.password = input.nextLine();

        System.out.println("\n[Account updated successfully!]");
    }

    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void pause(){
        System.out.print("Press Enter to continue...");
        input.nextLine();
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;

    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }


}