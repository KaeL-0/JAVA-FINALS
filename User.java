public abstract class User {
    String name;
    String email;
    String address;
    String phoneNumber;
    static Catalogue catalogue = new Catalogue();
    //Created static so catalogue will be shared among the seller and customer users

}