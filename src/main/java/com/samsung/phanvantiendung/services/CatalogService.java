package com.samsung.phanvantiendung.services;

import com.samsung.phanvantiendung.repositories.CatalogRepository;
import com.samsung.phanvantiendung.repositories.models.entities.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {
    @Autowired
    CatalogRepository catalogRepository;
    public List<Catalog> getAllCatalogs() {
        return catalogRepository.findAll();
    }
}
