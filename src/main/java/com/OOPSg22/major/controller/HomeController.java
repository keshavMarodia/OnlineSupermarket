package com.OOPSg22.major.controller;

import com.OOPSg22.major.global.GlobalData;
import com.OOPSg22.major.service.CategoryService;
import com.OOPSg22.major.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping({"/","/home"})
    public String home(Model model)
    {
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model)
    {
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProduct());
        return "shop";
    }
    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable int id)
    {
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProductsByCategoryId(id));
        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable Long id)
    {
        model.addAttribute("product",productService.getProductById(id).get());
        return "viewProduct";
    }


}
