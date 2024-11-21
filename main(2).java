import java.util.Scanner;
import java.util.InputMismatchException;


public class Mainn {

    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int user = 0;
        boolean loop = true;
        
        while(loop){
        try{
        
        System.out.println("____________________________");
        System.out.println("\n  E-COMMERCE LOGIN PAGE");
        System.out.println("____________________________");
        
        System.out.println("\nWhat type of user are you?");
        System.out.println("1. Customer");
        System.out.println("2. Seller");
        System.out.print("Enter here: ");
        user = input.nextInt();
        if(user == 1 || user == 2){
            loop = false;
        }
        else{
            System.out.println("Invalid input, please try again");
        }
        
        } catch(InputMismatchException e){
            System.out.println("Invalid input please enter a number");
            input.nextLine();
        }
        }
        
      
        loop = true;    
        
        while(loop){
        switch(user){
            
            case 1:
                
                loop = false;
                
                User customer = new Customer();
                customer.acquireInfo();
                
                System.out.println("\n\n******************");
                System.out.println("  CUSTOMER MENU");
                System.out.println("******************");
                
                System.out.println("1. View Catalogue");
                System.out.println("2. Place Order");
                System.out.println("3. View Shopping Cart");
                System.out.println("4. Display Account Info");
                System.out.println("5. Update Account Info");
                
                break;
            
            case 2:
                
                loop = false;
                
                break;
                
         
            default: 
                System.out.println("Invalid input please try again");
                  
        }
        }

       
    }
    
}
