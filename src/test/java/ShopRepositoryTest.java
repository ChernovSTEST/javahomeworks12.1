import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.NotFoundException;
import ru.netology.Product;
import ru.netology.ShopRepository;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveExistingElement() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 10);
        Product product2 = new Product(2, "Product 2", 20);

        repository.add(product1);
        repository.add(product2);

        repository.removeById(1);

        Product[] products = repository.findAll();
        Assertions.assertEquals(1, products.length);
        Assertions.assertEquals(product2, products[0]);
    }

    @Test
    public void shouldThrowExceptionForNonExistingElement() {
        ShopRepository repository = new ShopRepository();
        Product product = new Product(1, "Product 1", 10);

        repository.add(product);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(2);
        });
    }
}