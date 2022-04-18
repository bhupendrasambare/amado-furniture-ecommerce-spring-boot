package com.amado.controler;

import com.amado.service.brandService;
import com.amado.service.cartService;
import com.amado.service.categoryService;
import com.amado.service.productService;
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
        return "cart";
    }

    @GetMapping("account")
    public String account(Model model){
        model = common.getCommon(model);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "user";
    }
}
