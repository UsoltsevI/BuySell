package edu.phystech.buysell.services;

import edu.phystech.buysell.models.Product;
import edu.phystech.buysell.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import edu.phystech.buysell.models.Image;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> listProducts(String title) {
        if (title != null) {
            return productRepository.findByTitle(title);
        }
        return productRepository.findAll();
    }

    public void saveProduct(Product product
                            , MultipartFile file1
                            , MultipartFile file2
                            , MultipartFile file3) 
                            throws IOException {
        Image image1;
        Image image2;
        Image image3;

        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);
        }

        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            product.addImageToProduct(image2);
        }

        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            product.addImageToProduct(image3);
        }

        log.info("Saving new Product. Title: {}; Author: {}", product.getTitle(), product.getAuthor());
        Product productFromDb = productRepository.save(product);
        productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
        productRepository.save(product);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
