package com.company.controller;

import com.company.entity.Category;
import com.company.entity.Product;
import com.company.service.CategoryService;
import com.company.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable("id") int id) {
        Product product = productService.findById(id).get();
        List<Category> categories = categoryService.findAll();
        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("product", product);
        mv.addObject("categories", categories);
        System.out.println(product.getImage());
        return mv;
    }
}
