package com.rph.flipkartapp.controller;

import com.rph.flipkartapp.binding.SearchForm;
import com.rph.flipkartapp.entity.Mobile;
import com.rph.flipkartapp.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MobilesController {

    @Autowired
    private MobileService mobileService;

    @ModelAttribute
    public void loadFormData(Model model){


        model.addAttribute("brands",mobileService.getBrandNames());
        model.addAttribute("ram",mobileService.getMobileRam());
        model.addAttribute("rating",mobileService.getMobileRating());
    }

    @GetMapping("/loadPage")
    public String loadPage(Model model){
        SearchForm form = new SearchForm();
        model.addAttribute("formObject",form);
        return "index";
    }

    @PostMapping("/searchMobiles")
    public String SearchMobiles(@ModelAttribute("formObject") SearchForm formObj , Model model){
        System.out.println(formObj);
        List<Mobile> mobiles = mobileService.filterProduct(formObj);
        model.addAttribute("mobiles",mobiles);
        return "index";
    }

}
