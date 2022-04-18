package com.amado.controler;

import com.amado.service.brandService;
import com.amado.service.categoryService;
import com.amado.service.productService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class shop {
    @Autowired
    categoryService categoryService;

    @Autowired
    brandService brandService;

    @Autowired
    productService productService;

    @GetMapping("/shop")
    public String shop(Model model){
        model = common.getCommon(model);
        model.addAttribute("categories",categoryService.getCategories());
        model.addAttribute("brands",brandService.findAll());
        model.addAttribute("products",productService.getAll());
        return "shop";
    }

    @GetMapping("/categories/{name}")
    public String getCategories(@PathVariable("name")String name,
                                Model model)
    {
        model = common.getCommon(model);
        model.addAttribute("categories",categoryService.getCategories());
        model.addAttribute("brands",brandService.findAll());
        model.addAttribute("products",productService.findByCategories(name));
        return "shop";
    }

    @GetMapping("/brand/{name}")
    public String getBrand(@PathVariable("name")String name,
                                Model model)
    {
        model = common.getCommon(model);
        model.addAttribute("categories",categoryService.getCategories());
        model.addAttribute("brands",brandService.findAll());
        model.addAttribute("products",productService.findByBrand(name));
        return "shop";
    }
}
