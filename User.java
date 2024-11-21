import java.util.Scanner;

public abstract class User {
    
    
    String name;
    String email;
    String address;
    String phoneNumber;
    static Catalogue catalogue = new Catalogue();
    //Created static so catalogue will be shared among the seller and customer users
    
    public void acquireInfo(){
        Scanner input = new Scanner(System.in);
        System.out.print("Name: ");
        this.name = input.nextLine();
        System.out.print("Email: ");
        this.email = input.nextLine();
        System.out.print("Address: ");
        this.address = input.nextLine();
        System.out.print("Phone Number: ");
        this.phoneNumber = input.nextLine();
        
        System.out.println("\n YOUR INFO");
        System.out.println("Name         : " + name);
        System.out.println("Email        : " + email);
        System.out.println("Address      : " + address);
        System.out.println("Phone Number : " + phoneNumber);
    }

 
}
