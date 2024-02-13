package FunctionalPrograming.Assignment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 class ShoppingCart {
    private Map<Product,Integer> products = new HashMap<>();
    public void addProduct(Product product) {
        products.put(product,products.getOrDefault(product,0)+1);
    }
    public Map<Product,Integer> getProducts() {
        return products;
    }
}
