import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Catalogue {
    private ArrayList<Product> productList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    //Transfers the passed productList to the productList in the catalogue
    public void addProduct(ArrayList <Product> productList){
        this.productList = productList;
    }

    //Displays catalogue, if empty, displays is empty
    public void viewCatalogue(){

        if (!productList.isEmpty()) {
            for (Product product : productList) {
                product.displayProduct();
                System.out.println();
            }
        } else {
            System.out.println("[Catalogue is empty]");

        }
    }

    //Checks if the product exists in the catalogue, then returns a boolean
    public boolean checkCatalogue(int checkProductID){


        boolean productExist = false;


            for (Product product : productList) {
                if (product.getProductID() == checkProductID) {
                    productExist = true;
                }

            }


        return productExist;

    }

    //Checks if the product exists in the catalogue. If true, returns the product
    public Product returnProduct(int checkProductID){

        Product productToReturn = null;

        for (Product product : productList) {
            if (product.getProductID() == checkProductID){
                productToReturn = product;
            }

        }
        return productToReturn;
    }

    //Removes product from catalogue
    public void removeCatalogueItem (){

        if(!productList.isEmpty()) {
            //Display catalogue
            viewCatalogue();

            boolean productExist = false;
            int productToRemove;

            //Prompt to enter product ID of product to remove
            System.out.print("Enter product ID: ");
            productToRemove = input.nextInt();
            input.nextLine();

            Iterator<Product> iter = productList.iterator();

            //Traverse product list
            while (iter.hasNext()) {
                Product product = iter.next();

                //If product exist, remove product
                if (product.getProductID() == productToRemove) {
                    productExist = true;

                    iter.remove();
                    System.out.println("\n[Product removed]");

                }
            }

            //Else display order does not exist
            if (!productExist) {
                System.out.println("\n[Product does not exist]\n");
            }
        } else {
            System.out.println("[Catalogue is empty]");
        }

    }

    public void updateCatalogueItem() {
            int productToModify;
            boolean productExist = false;

            //Display catalogue
            viewCatalogue();


            if (!productList.isEmpty()) {
                while (!productExist) {
                    //Display prompt to enter product ID of product to modify
                    System.out.print("Enter product ID: ");
                    productToModify = input.nextInt();
                    input.nextLine();

                    //Traverse product list to check if product exist
                    for (Product product : productList) {
                        boolean confirm = false;


                        //If product exist, enter new product details
                        if (productToModify == product.getProductID()) {


                            while (!confirm) {
                                System.out.println("\nPRODUCT TO UPDATE\n");
                                product.displayProduct();


                                productExist = true;


                                System.out.print("\nEnter new name: ");
                                product.setProductName(input.nextLine());


                                System.out.print("Enter new price: ");
                                product.setProductPrice(input.nextDouble());
                                input.nextLine();

                                System.out.print("Enter new stock: ");
                                product.setProductStock(input.nextInt());
                                input.nextLine();

                                System.out.print("Enter new description: ");
                                product.setProductDescription(input.nextLine());

                                System.out.println("\nUPDATED PRODUCT");
                                product.displayProduct();

                                System.out.print("\nConfirm [Y/N]: ");
                                String confirmChoice = input.nextLine();

                                if (confirmChoice.equalsIgnoreCase("Y")) {
                                    confirm = true;
                                    System.out.println("\n[Product updated]");
                                }

                            }


                        } else {

                            System.out.println("[Product does not exist]\n");
                        }





                    }
                }

                if (!productExist) {
                    System.out.println("[Product does not exist]\n");

                }
            }
        }
    }
