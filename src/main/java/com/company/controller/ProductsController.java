package com.company.controller;

import com.company.Cart;
import com.company.dto.*;
import com.company.entity.*;
import com.company.service.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductsController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    RoleService roleService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    Cart cart;

    List<Product> products = new ArrayList<Product>();

    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @GetMapping("/products")
    public ModelAndView showProductPage(@RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "search", required = false) String name,
            HttpServletRequest request) throws IOException {
        List<Category> categories = categoryService.findAll();
        ModelAndView mv = new ModelAndView("products");
        String remoteUserEmail = request.getRemoteUser();
        User u = userService.findByEmail(remoteUserEmail).get(0);

        if (u.getRole().getName().equals("ADMIN")) {
            mv.addObject("userRole", "ADMIN");
        } else {
            mv.addObject("userRole", "USER");
        }
        if (name != null && !name.trim().equals("")) {
            if (category == null) {
                products = productService.findByName(name);
            } else {
                products = productService.findByCategoryAndName(name, category);
            }
        } else {
            if (category == null) {
                products = productService.findAll();
            } else {
                products = productService.findByCategory(category);
            }
        }
        if (products.size() == 0) {
            mv.addObject("categories", categories);
            mv.addObject("products", products);
            mv.addObject("searchInfo", "No results found");
            return mv;
        }
        mv.addObject("categories", categories);
        mv.addObject("cart", cart.getCart());
        mv.addObject("cartSize", cart.getCart().size());
        mv.addObject("searchInfo", "");
        mv.addObject("products", products);
        return mv;
    }

    @PostMapping("/products")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ModelAndView deleteProduct(@RequestParam(value = "button", required = false) String actionType,
            @RequestParam(value = "id", required = false) int productId,
            HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView("products");
        if (actionType.equals("Delete")) {
            Product product = productService.findById(productId).get();
            productService.deleteById(productId);
            products.remove(product);
        }
        response.sendRedirect("products");
        return mv;
    }

    @GetMapping("addProduct")
    public ModelAndView showAddProductsPage(WebRequest request, Model model) {
        List<Category> categories = categoryService.findAll();
        ModelAndView mv = new ModelAndView("addProduct");
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto", productDto);
        mv.addObject("categories", categories);
        return mv;
    }

    @PostMapping("addProduct")
    public ModelAndView showAddProductsPage(@ModelAttribute("productDto") @Valid ProductDto productDto, BindingResult result,
            HttpServletResponse response) throws IOException {
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
            ModelAndView mv = new ModelAndView();
            List<Category> categories = categoryService.findAll();
            mv.addObject("categories", categories);
            mv.addObject("message", ex.getMessage());
            return mv;
        }

        Product product = new Product();
        product.setName(productDto.getName());
        product.setImage(productDto.getImage());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());

        Category category = categoryService.findByName(productDto.getCategory()).get(0);
        product.setCategory(category);
        productService.save(product);
        ModelAndView mv = new ModelAndView("products");
        response.sendRedirect("products");
        return mv;
    }
}
