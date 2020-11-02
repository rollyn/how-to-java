package com.wisphil.controller;

import com.wisphil.model.AccountDto;
import com.wisphil.service.BankingSystemProService;
import com.wisphil.service.implementation.BankingSystemProServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BankingSystemProController {

    @Autowired
    private BankingSystemProService service;

    @GetMapping("/")
    public String homePage() {
        return "index";
    }
    @GetMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("company","Googly Software Development Ltd");
        return "about";
    }
    @GetMapping("/contact")
    public String contactPage(Model model) {

        AccountDto account = new AccountDto();
        model.addAttribute("account",account);
        return "contact";
    }


    @PostMapping("/contact")
    public String contactPage(@ModelAttribute AccountDto account, Model model) {
        service.createContact(account);
        return "index";
    }

}
