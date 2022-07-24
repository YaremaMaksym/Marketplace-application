import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Market market = new Market();
        Order order = new Order();

        market.addProduct(new Product("t-shirt", 200));
        market.addProduct(new Product("shirt", 200));
        market.addProduct(new Product("sweater", 200));
        market.addProduct(new Product("cap", 100));

        market.addUser(new User("Yuliy", "Oles", 1000));
        market.addUser(new User("Inna", "Kravchuk", 500));
        market.addUser(new User("Nazar", "Sokolov", 900));


        while(true) {
            Scanner str = new Scanner(System.in);
            int userId, productId;
            System.out.print("""
                    ____________________________________________________________
                    1 - Display list of all users                               |
                    2 - Display list of all products                            |
                    3 - Create order                                            |
                    4 - Display list of user products by user id                |
                    5 - Display list of users that bought product by product id |
                                                                                |
                    6 - Add new user                                            |
                    7 - Add new product                                         |
                    8 - Delete user                                             |
                    9 - Delete product                                          |
                                                                                |
                    0 - Exit program                                            |
                    ____________________________________________________________|
                    """);
            System.out.print("Enter your choice: ");
            int choice = convertAndCheckInt();

            System.out.println();


            switch (choice) {
                case 1:
                    //Display list of all users
                    market.printUsers();
                    break;

                case 2:
                    //Display list of all products
                    market.printProducts();
                    break;

                case 3:
                    //Create order
                    System.out.print("Please enter the user id: ");
                    userId = convertAndCheckInt();

                    System.out.print("\nPlease enter the product id: ");
                    productId = convertAndCheckInt();

                    order.createOrder(userId, productId, market);
                    break;

                case 4:
                    //Display list of user products by user id
                    System.out.print("Please enter the user id: ");

                    userId = convertAndCheckInt();

                    order.printProductsByUser(userId, market);
                    break;

                case 5:
                    //Display list of users that bought product by product id
                    System.out.print("Please enter the product id: ");

                    productId = convertAndCheckInt();

                    order.printUsersByProduct(productId, market);
                    break;

                case 6:
                    //Add new user
                    System.out.print("Please enter the user's first name: ");
                    String firstName = str.nextLine();

                    while (Objects.equals(firstName, "")) {
                        System.out.print("You entered a null first name, please enter again: ");
                        firstName = str.nextLine();
                    }

                    System.out.print("Please enter the user's last name: ");
                    String lastName = str.nextLine();

                    while (Objects.equals(lastName, "")) {
                        System.out.print("You entered a null last name, please enter again: ");
                        lastName = str.nextLine();
                    }


                    System.out.print("Please enter the amount of money: ");

                    int amountOfMoney = convertAndCheckInt();


                    market.addUser(new User(firstName, lastName, amountOfMoney));
                    break;

                case 7:
                    //Add new product
                    System.out.print("Please enter the product name: ");
                    String name = str.nextLine();

                    while (Objects.equals(name, "")) {
                        System.out.print("You entered a null name, please enter again: ");
                        name = str.nextLine();
                    }

                    System.out.print("Please enter the product price: ");

                    int price = convertAndCheckInt();

                    market.addProduct(new Product(name, price));
                    break;
                case 8:
                    //Delete user
                    System.out.print("Please enter the id of the user you want to delete: ");

                    userId = convertAndCheckInt();

                    order.deleteUserFromUsersByProduct(userId, market);
                    break;
                case 9:
                    //Delete product
                    System.out.print("Please enter the id of the product you want to delete: ");

                    productId = convertAndCheckInt();

                    order.deleteProductFromProductsByUser(productId, market);
                    break;
                case 0:
                    //Exit program
                    System.exit(0);
                    break;
                default:
                    System.out.println("You entered not valid menu option! Please select another");
                    break;
            }
        }
    }


    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }


    private static int convertAndCheckInt(){
        Scanner input = new Scanner(System.in);

        String strValue = input.nextLine();
        while (!isNumeric(strValue)){
            System.out.print("You entered a not a number, please enter again: ");
            strValue = input.nextLine();
        }
        return Integer.parseInt(strValue);
    }

}
