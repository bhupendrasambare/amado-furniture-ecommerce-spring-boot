package com.amado.controler;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

public class common {

    public static Model getCommon(Model model){
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        if(auth.getName() == "anonymousUser"){
            model.addAttribute("login","Login");
            model.addAttribute("register","Register");
        }else{
            model.addAttribute("login","Account");
            model.addAttribute("register","Logout");
        }
        return model;
    }
}
