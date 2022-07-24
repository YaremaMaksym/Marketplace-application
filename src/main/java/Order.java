import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Order{
    ArrayList<Product> pList = new ArrayList<>();
    LinkedHashMap<User, ArrayList<Product>> productsByUser = new LinkedHashMap<>();

    //creates new order
    public void createOrder(int userId, int productId, @NotNull Market market){
        User user = market.getUserById(userId);
        Product product = market.getProductById(productId);
        
        if ((user == null) && (product == null)){
            System.out.println("This user and product does not exist");
        } else if (product == null) {
            System.out.println("This product does not exist");
        } else if (user == null) {
            System.out.println("This user does not exist");
        } else {
            if(user.amountOfMoney < product.price){
                System.out.println(user.firstName + " " + user.lastName + " doesn't have enough money to buy product");
            }
            else{
                user.amountOfMoney -= product.price;

                if (productsByUser.get(user) == null){
                    if(pList != null){
                        pList.clear();
                    }
                    pList.add(product);

                    productsByUser.put(user, pList);
                }
                else{
                    productsByUser.get(user).add(product);
                }

                System.out.println(user.firstName + " " + user.lastName + " has successfully made a purchase");
            }
        }


    }

    //user products by user id
    public void printProductsByUser(int userId, @NotNull Market market) {
        User user = market.getUserById(userId);
        boolean showTop = true; //will show top of table

        if (user == null){
            //System.out.println("This user does not exist");
        } else {
            if (productsByUser.get(user) != null){
                for(int i = 0; i < productsByUser.get(user).size(); i++){
                    if (showTop){
                        System.out.println("\n" + user + "\n" + "---------------------------------------------------------------------");
                    }
                    showTop = false;
                    System.out.println(productsByUser.get(user).get(i));
                }
                System.out.println();
            }
        }
    }

    //users that bought product by product id
    public void printUsersByProduct(int productId, @NotNull Market market) {
        Product product = market.getProductById(productId);
        User user;
        boolean showTop = true; //will show top of table

        if (product == null) {
            //System.out.println("This product does not exist");
        } else {
            for(int i = 0; i < market.arrOfUsers.size(); i++){
                user = market.getUserById(i);

                if(productsByUser.get(user) == null){
                    continue;
                }

                for (int j = 0; j < productsByUser.get(user).size(); j++){
                    if(productsByUser.get(user).get(j) == product){
                        if (showTop){
                            System.out.println("\n" + product + "\n" + "---------------------------------------------------------------------");
                        }
                        showTop = false;

                        System.out.println(user);
                    }
                }
            }
            System.out.println();
        }
    }

    //Deletes user and his array with elements
    public void deleteUserFromUsersByProduct(int userId, @NotNull Market market){
        User user = market.getUserById(userId);

        if (user == null) {
            System.out.println("This user does not exist");
        } else {
            productsByUser.remove(user);    //Removes user's products
            market.deleteUser(userId);      //Removes user from array with all users

            System.out.println("The user with ID number - " + userId +  " has been successfully deleted");
        }
    }

    //Deletes elements of arrays owned by users
    public void deleteProductFromProductsByUser(int productId, @NotNull Market market) {
        Product product = market.getProductById(productId);
        User user;

        if (product == null) {
            System.out.println("This product does not exist");

        } else {
            for(int i = 0; i < market.arrOfUsers.size(); i++){
                user = market.getUserById(i);

                if(productsByUser.get(user) == null){
                    continue;
                }

                for (int j = 0; j < productsByUser.get(user).size(); j++){
                    if(productsByUser.get(user).get(j) == product){
                        productsByUser.get(user).remove(j);
                    }
                }
            }
            market.deleteProduct(productId);    //Removes product from array with all products

            System.out.println("The product with ID number - " + productId +  " has been successfully deleted");
        }
    }

}




















