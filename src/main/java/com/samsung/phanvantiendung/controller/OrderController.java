package com.samsung.phanvantiendung.controller;

import com.samsung.phanvantiendung.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public String orderList(final Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "order";
    }
}
