package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    
    @GetMapping("main")
    public ModelAndView showMainPage(){
        ModelAndView mv = new ModelAndView("main");
        return mv;
    }
}
