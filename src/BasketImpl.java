import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BasketImpl implements Basket {
    private final ProductRepository productRepository;
    static HashMap<String, Product> busket = new HashMap();
    public BasketImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(String product, int quantity) {
        Product productInBusket = productRepository.findByProductName(product)
                .orElseThrow(() -> new IllegalArgumentException("Ошибка операции! Товара нет в базе"));
        if (productInBusket.getQuantity() < quantity) {
            throw new IllegalArgumentException("");
        }
        busket.put(product,new Product(product, quantity));
    }

    @Override
    public void removeProduct(String product) {

    }

    @Override
    public void updateProductQuantity(String productName, int quantity) {
        // Обновление количества товара в корзине
        // ... (логика обновления количества товара в корзине)
    }

    @Override
    public void clear() {
        // Очистка корзины
        // ... (логика очистки корзины)
    }

    @Override
    public List<String> getProducts() {
        // Получение списка товаров в корзине
        // ... (логика получения списка товаров в корзине)

        return null;
    }

    @Override
    public int getProductQuantity(String productName) {
        // Получение количества товара в корзине
        // ... (логика получения количества товара в корзине)
        return 0;
    }
}

