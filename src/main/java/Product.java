import org.jetbrains.annotations.NotNull;
import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    int productId;
    String name;
    int price;

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);

    public Product(@NotNull String name, int price) {
        productId = ID_GENERATOR.getAndIncrement();
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "productId: " + productId + "\tname: " + name+ "\t\tprice: " + price;
    }
}
