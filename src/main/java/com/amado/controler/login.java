package com.amado.controler;

import com.amado.model.users;
import com.amado.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class login {

    @Autowired
    userService userService;

    @GetMapping("/login")
    public String login(Model model){
        model = common.getCommon(model);
        return "account/login";
    }

    @GetMapping("/forget")
    public String forgot(Model model){
        model = common.getCommon(model);
        return "account/forogt";
    }

    @GetMapping("/register")
    public String register(Model model){
        model = common.getCommon(model);
        return "account/register";
    }

    @PostMapping("/register")
    public String register(@RequestParam("name")String name,
                           @RequestParam("last") String last,
                           @RequestParam("email")String email,
                           @RequestParam("number")String number,
                           @RequestParam("password")String password
                            ){
        users user = new users(0,name,last,password,number,email);
        userService.create(user);
        return "redirect:/login";
    }
}
