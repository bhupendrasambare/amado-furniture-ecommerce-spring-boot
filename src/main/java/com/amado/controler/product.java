package com.amado.controler;

import com.amado.model.cart;
import com.amado.model.users;
import com.amado.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class product {

    @Autowired
    categoryService categoryService;

    @Autowired
    brandService brandService;

    @Autowired
    productService productService;

    @Autowired
    userService userService;

    @Autowired
    cartService cartService;

    @GetMapping("/product/{id}")
    public String product(@PathVariable("id")int id, Model model){
        model = common.getCommon(model);
        model.addAttribute("title","E commerce");
        model.addAttribute("product",productService.findById(id));
        return "product";
    }
    @PostMapping("/product/{id}")
    public String addProduct(@PathVariable("id")int id,
                             @RequestParam("quantity")int quantity){
        users user = userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        cartService.create(new cart(0,quantity,user,productService.findById(id)));
        return "redirect:/cart";
    }

}
