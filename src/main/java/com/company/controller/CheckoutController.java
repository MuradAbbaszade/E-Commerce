package com.company.controller;

import com.company.Cart;
import com.company.entity.Product;
import com.company.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CheckoutController {

    @Autowired
    ProductService productService;

    @Autowired
    Cart cart;

    @GetMapping("checkout/{id}")
    public ModelAndView showCheckoutPage(@PathVariable(value = "id") int productId) {
        ModelAndView mv = new ModelAndView("checkout");
        Product product = productService.findById(productId).get();
        mv.addObject("cart", null);
        mv.addObject("product", product);
        return mv;
    }

    @GetMapping("/checkout")
    public ModelAndView showCheckoutPage() {
        ModelAndView mv = new ModelAndView("checkout");
        double total = 0 ;
        for(Product product : cart.getCart()){
            total+=product.getPrice();
        }
        mv.addObject("total", total);
        mv.addObject("cart", cart.getCart());
        mv.addObject("product", null);
        return mv;
    }
}
