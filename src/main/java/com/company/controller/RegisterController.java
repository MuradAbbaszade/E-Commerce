package com.company.controller;

import com.company.dto.UserDto;
import com.company.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @Autowired
    UserRegisterService registerService;
    @GetMapping("register")
    public ModelAndView showRegisterPage() {
        ModelAndView mv = new ModelAndView("register");
        return mv;
    }

    @PostMapping("register")
    public ModelAndView showRegisterPage(@RequestParam(value="name",required=false)String name,
            @RequestParam(value="email",required=false)String email,
            @RequestParam(value="password",required=false)String password) {
        UserDto userDto = new UserDto();
        userDto.setName(name);
        userDto.setEmail(email);
        userDto.setPassword(password);
        registerService.registerNewUserAccount(userDto);
        ModelAndView mv = new ModelAndView("register");
        return mv;
    }
}
