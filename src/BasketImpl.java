


import org.slf4j.Logger;

import java.util.*;

public class BasketImpl implements Basket {

    //    private final Logger logger = LoggerFactory.getLogger(BasketImpl.class);
    private final ProductRepository productRepository;
    private static HashMap<String, Product> busket = new HashMap();

    public BasketImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(String product, int quantity) {
        Product productInBusket = productRepository.findByProductName(product)
                .orElseThrow(() -> new MissingItemException("Ошибка операции! Товара нет в базе"));
        if (productInBusket.getQuantity() < quantity) {
            throw new MissingItemException(String.format("Товар отсуствует на складе в количестве %d штук!\n", quantity));
        }
        busket.put(product, new Product(product, quantity));
    }

    @Override
    public void removeProduct(String product) {
        if (busket.containsKey(product)) {
            busket.remove(product);
            System.out.printf("Товар %s был удален\n", product);
        } else {
            throw new MissingItemException("Товар отсутствует в корзине. Удаление невозможно!");
        }
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        if (busket.containsKey(product)) {

            Product productInBusket = productRepository.findByProductName(product).get();
            if (productInBusket.getQuantity() < quantity) {
                throw new MissingItemException(String.format("Товар отсуствует на складе в количестве %d штук!\n", quantity));
            }

            busket.put(product, new Product(product, quantity));
        } else {
            throw new MissingItemException("Товар отсутствует в корзине!");
        }
    }

    @Override
    public void clear() {
        busket.clear();
        System.out.println("Все товары удалены из корзины!");
    }

    @Override
    public List<String> getProducts() {

        List<String> productList = new ArrayList<>();

        for (Map.Entry<String, Product> productEntry : busket.entrySet()) {
            System.out.println("Product name: " + productEntry.getKey() + "\n");
            productList.add(productEntry.getKey());
        }
        return productList;

    }

    @Override
    public int getProductQuantity(String product) {
        Product product1 = busket.get(product);
        return product1.getQuantity();
    }

    public HashMap<String, Product> returnBusketList() {
        return busket;
    }
}

