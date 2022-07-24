import java.util.ArrayList;

public class Market {
    ArrayList<Product> arrOfProducts = new ArrayList<>();
    ArrayList<User> arrOfUsers = new ArrayList<>();

    void addProduct(Product product){
        arrOfProducts.add(product);
    }
    void addUser(User user){
        arrOfUsers.add(user);
    }

    void deleteUser(int userId){
        arrOfUsers.remove(userId);
    }
    void deleteProduct(int productId){
        arrOfProducts.remove(productId);
    }

    public void printProducts() {
        for (Product arrOfProduct : arrOfProducts) {
            System.out.println(arrOfProduct);
        }
    }
    public void printUsers() {
        for (User arrOfUser : arrOfUsers) {
            System.out.println(arrOfUser);
        }
    }

    public User getUserById(int userId){
        for (User arrOfUser : arrOfUsers) {
            if (userId == arrOfUser.userId) {
                return arrOfUser;
            }
        }
        return null;
    }
    public Product getProductById(int productId){
        for (Product arrOfProduct : arrOfProducts) {
            if (productId == arrOfProduct.productId) {
                return arrOfProduct;
            }
        }
        return null;
    }
}
