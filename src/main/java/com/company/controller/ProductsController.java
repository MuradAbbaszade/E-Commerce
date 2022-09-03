package com.company.controller;

import com.company.entity.Product;
import com.company.entity.User;
import com.company.service.ProductService;
import com.company.service.RoleService;
import com.company.service.UserService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductsController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    RoleService roleService;

    List<Product> products = new ArrayList<Product>();

    @GetMapping("/products")
    public ModelAndView showProductPage(@RequestParam(value = "search", required = false) String name,
            HttpServletRequest request) throws IOException {
        ModelAndView mv = new ModelAndView("products");
        String remoteUserEmail = request.getRemoteUser();
        User u = userService.findByEmail(remoteUserEmail).get(0);
        
        if(u.getRole().getName().equals("ADMIN")){
            mv.addObject("userRole", "ADMIN");
        }
        else{
            mv.addObject("userRole","USER");
        }
        if (name != null && !name.trim().equals("")) {
            products = productService.findByName(name);
        } else {
            products = productService.findAll();
        }
        if (products.size() == 0) {
            mv.addObject("products", products);
            mv.addObject("searchInfo", "No results found");
            return mv;
        }
        mv.addObject("searchInfo", "");
        mv.addObject("products", products);
        return mv;
    }
    
    @PostMapping("/products")
    public ModelAndView showProductPage(@RequestParam(value="button",required=false)String actionType,
            @RequestParam(value="id",required=false)int productId){
        ModelAndView mv = new ModelAndView("products");
        if(actionType.equals("Delete")){
            productService.deleteById(productId);
        }
        mv.addObject("products", products);
        return mv;
    }
}
