package com.samsung.phanvantiendung.controller;

import com.samsung.phanvantiendung.repositories.models.FilterModel;
import com.samsung.phanvantiendung.repositories.models.entities.Order;
import com.samsung.phanvantiendung.repositories.models.entities.Product;
import com.samsung.phanvantiendung.services.CatalogService;
import com.samsung.phanvantiendung.services.OrderService;
import com.samsung.phanvantiendung.services.ProductService;
import com.samsung.phanvantiendung.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
public class HomeController {
    private final UserService userService;
    CatalogService catalogService;
    ProductService productService;
    OrderService orderService;
    public HomeController(CatalogService catalogService,
                          ProductService productService,
                          OrderService orderService,
                          UserService userService) {
        this.catalogService = catalogService;
        this.productService = productService;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/home")
    public String home(final Model model) {
        model.addAttribute("catalogs", catalogService.getAllCatalogs());
        model.addAttribute("filterModel", FilterModel.builder().catalogType("All").searchProduct("").build());
        model.addAttribute("products", productService.getAllProducts());
        return "home";
    }

    @PostMapping("/search-product")
    public String searchProduct(@ModelAttribute FilterModel filterModel, final Model model) {
        String searchProduct = filterModel.getSearchProduct();

        model.addAttribute("catalogs", catalogService.getAllCatalogs());
        model.addAttribute("filterModel", filterModel);
        model.addAttribute("products",
                productService.getAllProducts().stream()
                        .filter(i -> i.getName().contains(searchProduct))
                        .collect(Collectors.toList())
        );

        return "home";
    }

    @PostMapping("/filter-by-catalog")
    public String filterByCatalog(@RequestParam("id") Integer catalogId, final Model model) {
        model.addAttribute("catalogs", catalogService.getAllCatalogs());
        model.addAttribute("filterModel", FilterModel.builder().catalogType("All").searchProduct("").build());
        model.addAttribute("products", productService.getAllProducts());
        return "home";
    }

    @PostMapping("/buy-now/{id}")
    public String buyNow(@PathVariable("id") Long productId, final Model model) {
        orderService.AddOrder(Order.builder()
                .user(userService.getUserById(1L))
                .total_qty(1)
                .total_amount(productService.getProductById(productId).getPrice())
                .build()
        );

        model.addAttribute("orders", orderService.getAllOrders());
        return "order";
    }
}
