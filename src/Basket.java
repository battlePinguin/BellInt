import java.util.List;
public interface Basket {
    void addProduct(String productName, int quantity);
    void removeProduct(String productName);
    void updateProductQuantity(String productName, int quantity);
    void clear();
    List<String> getProducts();
    int getProductQuantity(String productName);
}
