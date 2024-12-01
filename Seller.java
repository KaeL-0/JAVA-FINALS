import java.util.ArrayList;
import java.util.Scanner;

class Seller extends User  {

    Scanner input = new Scanner(System.in);

    private ArrayList<Product> productList;
    private Product product;
    private int productID;


    Seller (){
        product = null;
        productID = 0;
        productList = new ArrayList<>();

        this.name = null;
        this.address = null;
        this.phoneNumber = null;

    }


    //For seller to add product to the catalogue
    public void addProduct(){

        //Create new product and increment product ID
        productID++;
        product = new Product(productID);

        //Input product info
        System.out.print("Enter product name: ");
        product.setProductName(input.nextLine());

        System.out.print("Enter product price: ");
        product.setProductPrice(input.nextDouble());
        input.nextLine();

        System.out.print("Enter product stock: ");
        product.setProductStock(input.nextInt());
        input.nextLine();

        System.out.print("Enter product description: ");
        product.setProductDescription(input.nextLine());

        productList.add(product);

        catalogue.addProduct(productList);
        System.out.println("\n[Product added to catalogue]");

    }

    public void sellerMenu() {
        boolean exitSellerMenu = false;

        while (!exitSellerMenu) {
            clear();
            System.out.println("\n\n======== SELLER MENU =========");
            System.out.println("[1] View Catalogue");
            System.out.println("[2] Display Account");
            System.out.println("[3] Update Account Info");
            System.out.println("[4] Logout");
            System.out.println("[5] Exit");
            System.out.println("======== SELLER MENU =========");
            System.out.print("\nEnter choice: ");

            try {
                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        viewCatalogue();
                        break;

                    case 2:
                        clear();
                        System.out.println("\n\n====== ACCOUNT INFORMATION ======");
                        displayAccount();
                        break;
                    case 3:
                        clear();
                        System.out.println("\n\n=== UPDATE ACCOUNT INFORMATION ===");
                        System.out.println();
                        updateAccountInfo();
                        break;
                    case 4:
                        clear();
                        exitSellerMenu = true;
                        break;
                    case 5:
                        System.out.println();
                        System.out.println("Thank you for shopping with us!");   // temporary
                        System.exit(0);
                    default:
                        System.out.println("[Invalid choice, please try again.]");
                }
            } catch (Exception e) {
                System.out.println("[Invalid input. Please enter a valid number.]");
                exitSellerMenu = true;
            }
        }
    }


    public void viewCatalogue(){
        boolean exitCatalogueMenu = false;

        while (!exitCatalogueMenu) {
            clear();
            System.out.println("\n\n===== SELLER CATALOGUE MENU =====");
            System.out.println("[1] View Products");
            System.out.println("[2] Add Catalogue Item");
            System.out.println("[3] Search Catalogue");
            System.out.println("[4] Update Catalogue Item");
            System.out.println("[5] Remove Catalogue Item");
            System.out.println("[6] Back to Seller Menu");
            System.out.println("===== SELLER CATALOGUE MENU =====");

            System.out.print("\nEnter choice: ");

            try {
                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {

                    case 1:
                        clear();
                        System.out.println("\n\n===== VIEW CATALOGUE =====\n");
                        catalogue.viewCatalogue();
                        System.out.println();
                        pause();
                        break;

                    case 2:
                        System.out.println("\n\n===== ADD CATALOGUE =====");
                        addProduct();

                        break;
                    case 3:
                        clear();
                        System.out.println("\n\n===== SEARCH PRODUCT =====");

                        if(!productList.isEmpty()) {
                            System.out.print("Enter Product ID to check: ");
                            int checkProductID = input.nextInt();
                            input.nextLine();



                            if (catalogue.checkCatalogue(checkProductID)) {
                                System.out.println("\n[Product exists in the catalogue]\n");

                                Product returnProduct = new Product(checkProductID);
                                returnProduct = catalogue.returnProduct(checkProductID);
                                returnProduct.displayProduct();


                            } else {
                                System.out.println("\n[Product does not exist]");
                            }
                            System.out.println();
                            pause();

                        } else {
                            System.out.println("[Catalogue is empty]");
                        }
                        break;
                    case 4:
                        clear();
                        System.out.println("\n\n====== UPDATE PRODUCT ======\n");
                        catalogue.updateCatalogueItem();
                        System.out.println();
                        pause();
                        break;
                    case 5:
                        clear();
                        System.out.println("\n\n====== REMOVE PRODUCT ======");
                        catalogue.removeCatalogueItem();
                        System.out.println();
                        pause();
                        break;
                    case 6:
                        exitCatalogueMenu = true;
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                exitCatalogueMenu = true;
            }
        }
    }


}
