package com.company.controller;

import com.company.dto.ProductDto;
import com.company.entity.Category;
import com.company.entity.Product;
import com.company.service.CategoryService;
import com.company.service.ProductService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @GetMapping("edit/{id}")
    public ModelAndView showEditPage(WebRequest request, Model model, @PathVariable("id") int id) {
        Product product = productService.findById(id).get();
        List<Category> categories = categoryService.findAll();
        ModelAndView mv = new ModelAndView("edit");
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto", productDto);
        mv.addObject("product", product);
        mv.addObject("categories", categories);
        return mv;
    }

    @PostMapping("edit/{id}")
    public ModelAndView showEditPage(@ModelAttribute("productDto") @Valid ProductDto productDto, BindingResult result,
            HttpServletResponse response, @PathVariable("id") int id) throws IOException {
        System.out.println(id);
        System.out.println(productDto.getName());
        try {
            if (result.hasErrors()) {
                Object obj = result.getAllErrors().get(0);
                ObjectError objectError = null;
                if (obj instanceof ObjectError) {
                    objectError = (ObjectError) obj;
                }
                String message = messageSource().getMessage(objectError, null);
                if (message.contains("NumberFormatException")) {
                    message = "Please fill the all fields";
                }
                throw new Exception(message);
            }
        } catch (Exception ex) {
            System.out.println("2");
            ModelAndView mv = new ModelAndView("edit");
            Product product = productService.findById(id).get();
            mv.addObject("product", product);
            List<Category> categories = categoryService.findAll();
            mv.addObject("categories", categories);
            System.out.println(product.getName());
            mv.addObject("message", ex.getMessage());
            System.out.println(categories.get(0).getName());
            return mv;
        }
        Product product = productService.findById(id).get();
        product.setName(productDto.getName());
        product.setImage(productDto.getImage());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());

        Category category = categoryService.findByName(productDto.getCategory()).get(0);
        product.setCategory(category);
        productService.save(product);
        ModelAndView mv = new ModelAndView();
        response.sendRedirect("/E-Commerce/products");
        return mv;
    }
}
