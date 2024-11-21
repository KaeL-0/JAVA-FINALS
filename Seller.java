import java.util.ArrayList;
import java.util.Scanner;



public class Seller extends User  {

    Scanner input = new Scanner(System.in);

    private ArrayList <Product> productList = new ArrayList<>();
    private Product product = null;
    private int productID = 0;


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

        //Store product to product list
        productList.add(product);

        //Transfer product list to catalogue
        catalogue.addProduct(productList);
        System.out.println("\n[Product added to catalogue]");

    }

    //To view catalogue
    public void viewCatalogue(){


        //Create menu for these class methods:
        //catalogue.removeCatalogueItem();
        //catalogue.viewCatalogue();
        //catalogue.checkCatalogue();
        //catalogue.updateCatalogueItem

        catalogue.updateCatalogueItem();


    }






}
