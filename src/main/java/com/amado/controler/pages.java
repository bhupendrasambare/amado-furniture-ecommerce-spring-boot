package com.amado.controler;

import com.amado.model.cart;
import com.amado.model.users;
import com.amado.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pages {

    @Autowired
    categoryService categoryService;

    @Autowired
    brandService brandService;

    @Autowired
    productService productService;

    @Autowired
    com.amado.service.cartService cartService;

    @Autowired
    com.amado.service.userService userService;

    @GetMapping({"","/index","/"})
    public String home(Model model){
        model = common.getCommon(model);
        model.addAttribute("title","E commerce");
        model.addAttribute("products",productService.getAll());
        return "index";
    }

    @GetMapping("product")
    public String product(Model model){
        model = common.getCommon(model);
        model.addAttribute("cat",categoryService.getCategories());
        return "product";
    }

    @GetMapping("cart")
    public String cart(Model model){
        model = common.getCommon(model);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("carts",cartService.getByUser(auth.getName()));
        double total=0;
        for(cart c : cartService.getByUser(auth.getName())){
            total += c.getQuantity() * c.getProduct().getPrice();
        }
        model.addAttribute("total",total);
        return "cart";
    }

    @GetMapping("account")
    public String account(Model model){
        model = common.getCommon(model);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user",userService.findByEmail(auth.getName()));
        model.addAttribute("carts",cartService.getByUser(auth.getName()));
        return "user";
    }
}
