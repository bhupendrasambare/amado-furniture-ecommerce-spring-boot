package com.amado.controler;

import com.amado.model.brand;
import com.amado.model.categories;
import com.amado.model.product;
import com.amado.service.brandService;
import com.amado.service.categoryService;
import com.amado.service.otherServices;
import com.amado.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class inatilizer {

    @Autowired
    categoryService categoryService;

    @Autowired
    productService productService;

    @Autowired
    brandService brandService;

    @Autowired
    otherServices otherServices;

    @GetMapping("/initialize")
    public String inatilize(){
        if(categoryService.countCategories() < 1) {
            categoryService.create(new categories(0, "Chair"));
            categoryService.create(new categories(0, "Pot"));
            categoryService.create(new categories(0, "Stool"));
            categoryService.create(new categories(0, "Decoration"));
            categoryService.create(new categories(0, "Table"));
        }
        if(brandService.findAll().size() < 1){
            brandService.create(new brand(0,"Brand1","logo1.jpg"));
            brandService.create(new brand(0,"Brand2","logo4.jpg"));
            brandService.create(new brand(0,"Brand3","logo3.jpg"));
            brandService.create(new brand(0,"Brand4","logo3.jpg"));
            brandService.create(new brand(0,"Brand5","logo2.jpg"));
        }
        if(productService.getAll().size() <1){
            productService.create(new product(0,0,100,100.50,"Modern chair","This is the chair discription seen in many place used gor getting details about the product in case needed to ulful the discription",otherServices.getDate(),categoryService.findByName("Chair"),brandService.findByName("brand1"),"1.jpg"));
            productService.create(new product(0,0,100,100.50,"A simple chair","This is the chair discription seen in many place used gor getting details about the product in case needed to ulful the discription",otherServices.getDate(),categoryService.findByName("Chair"),brandService.findByName("brand1"),"3.jpg"));
            productService.create(new product(0,0,100,100.50,"Rocking chair","This is the chair discription seen in many place used gor getting details about the product in case needed to ulful the discription",otherServices.getDate(),categoryService.findByName("Chair"),brandService.findByName("brand1"),"8.jpg"));
            productService.create(new product(0,0,100,100.50,"Minimalistic Pot","This is the chair discription seen in many place used gor getting details about the product in case needed to ulful the discription",otherServices.getDate(),categoryService.findByName("pot"),brandService.findByName("brand2"),"5.jpg"));
            productService.create(new product(0,0,100,100.50,"Plant pot","This is the chair discription seen in many place used gor getting details about the product in case needed to ulful the discription",otherServices.getDate(),categoryService.findByName("pot"),brandService.findByName("brand2"),"6.jpg"));
            productService.create(new product(0,0,100,100.50,"High Stool","This is the chair discription seen in many place used gor getting details about the product in case needed to ulful the discription",otherServices.getDate(),categoryService.findByName("stool"),brandService.findByName("brand3"),"7.jpg"));
            productService.create(new product(0,0,100,100.50,"Mini Pot Decoration","This is the chair discription seen in many place used gor getting details about the product in case needed to ulful the discription",otherServices.getDate(),categoryService.findByName("Decoration"),brandService.findByName("brand4"),"2.jpg"));
            productService.create(new product(0,0,100,100.50,"Home hanging","This is the chair discription seen in many place used gor getting details about the product in case needed to ulful the discription",otherServices.getDate(),categoryService.findByName("Decoration"),brandService.findByName("brand4"),"9.jpg"));
            productService.create(new product(0,0,100,100.50,"Simple table","This is the chair discription seen in many place used gor getting details about the product in case needed to ulful the discription",otherServices.getDate(),categoryService.findByName("Table"),brandService.findByName("brand5"),"6.jpg"));
            productService.create(new product(0,0,100,100.50,"Box table","This is the chair discription seen in many place used gor getting details about the product in case needed to ulful the discription",otherServices.getDate(),categoryService.findByName("Table"),brandService.findByName("brand5"),"4.jpg"));
        }
        return "redirect:/";
    }
}
