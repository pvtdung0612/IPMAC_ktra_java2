package com.samsung.phanvantiendung.services;

import com.samsung.phanvantiendung.repositories.CatalogRepository;
import com.samsung.phanvantiendung.repositories.ProductRepository;
import com.samsung.phanvantiendung.repositories.models.Catalog;
import com.samsung.phanvantiendung.repositories.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
