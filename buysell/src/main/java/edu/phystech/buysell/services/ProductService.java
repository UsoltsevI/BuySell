package edu.phystech.buysell.services;

import edu.phystech.buysell.models.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Product("PlayStation", "Just buy and play!", "Pavel", "Samara", ++ID, 67000));
        products.add(new Product("Iphone 13", "Iphone is in a good condition", "Sergay", "Moscow", ++ID, 37000));
    }

    public List<Product> listProducts() {
        return products;
    }

    public void saveProduct(Product product) {
        product.setId(++ID);
        products.add(product);
    }

    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }

        return null;
    }
}
