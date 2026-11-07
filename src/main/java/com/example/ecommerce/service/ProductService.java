package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // حقن التبعيات عبر المُنشئ (Constructor Injection)
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 1. استرجاع كل المنتجات
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 2. البحث عن منتج بالمعرف (ID)
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    // 3. إضافة منتج جديد
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // 4. تعديل منتج موجود
    public Product updateProduct(String id, Product newProduct) {
        if (productRepository.existsById(id)) {
            newProduct.setId(id);
            return productRepository.save(newProduct);
        }
        return null;
    }

    // 5. حذف منتج
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}