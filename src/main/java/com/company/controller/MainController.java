package com.company.controller;

import com.company.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    Cart cart;

    @GetMapping("main")
    public ModelAndView showMainPage() {
        ModelAndView mv = new ModelAndView("main");
        mv.addObject("cartSize", cart.getCart().size());
        return mv;
    }
}
