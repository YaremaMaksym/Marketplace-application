import java.util.concurrent.atomic.AtomicInteger;

public class User {
    int userId;
    String firstName;
    String lastName;
    int amountOfMoney;

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);

    public User(String firstName, String lastName, int amountOfMoney) {

        userId = ID_GENERATOR.getAndIncrement();
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public String toString() {
        return "userId: " + userId + "\tfirstName: " + firstName+ "\t\tlastName: " + lastName + "\tamountOfMoney: " + amountOfMoney;
    }
}