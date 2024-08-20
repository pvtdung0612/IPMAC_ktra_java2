package com.samsung.phanvantiendung.controller;

import com.samsung.phanvantiendung.repositories.models.SearchModel;
import com.samsung.phanvantiendung.services.CatalogService;
import com.samsung.phanvantiendung.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    CatalogService catalogService;
    ProductService productService;
    public HomeController(CatalogService catalogService, ProductService productService) {
        this.catalogService = catalogService;
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(final Model model) {
        model.addAttribute("catalogs", catalogService.getAllCatalogs());
        model.addAttribute("searchProduct", SearchModel.builder().build());
        model.addAttribute("products", productService.getAllProducts());
        return "home";
    }

    @PostMapping("/search-product")
    public String searchProduct(@ModelAttribute SearchModel searchProduct, final Model model) {
        model.addAttribute("catalogs", catalogService.getAllCatalogs());
        model.addAttribute("searchProduct", searchProduct);
        model.addAttribute("products", productService.getAllProducts());
        return "home";
    }
}
