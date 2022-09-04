package com.company.controller;

import com.company.Cart;
import com.company.entity.Category;
import com.company.entity.Product;
import com.company.service.CategoryService;
import com.company.service.ProductService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

    @Autowired
    Cart cart;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("cart")
    public ModelAndView addToCart(@RequestParam(value = "id", required = false) int id,
            HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView("products");
        Product product = productService.findById(id).get();
        if (!cart.getCart().contains(product)) {
            cart.getCart().add(product);
        }
        List<Product> products = new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        products = productService.findAll();
        categories = categoryService.findAll();
        mv.addObject("cart", cart);
        mv.addObject("cartSize", cart.getCart().size());
        mv.addObject("categories", categories);
        mv.addObject("products", products);
        mv.addObject("userRole", "USER");
        return mv;
    }
    
    @PostMapping("cart")
    public ModelAndView deleteFromCart(@RequestParam(value="id",required=false)int id,
            HttpServletResponse response) throws IOException{
        ModelAndView mv = new ModelAndView("checkout");
        Product product = productService.findById(id).get();
        cart.getCart().remove(product);
        response.sendRedirect("checkout");
        return mv;
    }
}
