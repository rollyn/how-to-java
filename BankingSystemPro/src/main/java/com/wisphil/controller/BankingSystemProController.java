package com.wisphil.controller;

import com.wisphil.model.AccountDto;
import com.wisphil.repository.BankingSystemProRepository;
import com.wisphil.service.BankingSystemProService;
import com.wisphil.service.implementation.BankingSystemProServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/account")
    public String contactPage(Model model) {

        AccountDto account = new AccountDto();
        model.addAttribute("savings",account);
        return "account";
    }

    @Autowired
    private BankingSystemProRepository repository;

    @PostMapping("/account")
    public String contactPage(@ModelAttribute AccountDto account, Model model) {
        service.createContact(account);
        return "index";
    }

    @GetMapping("/list")
    public String listAccount(Model model) {
        List<AccountDto> accounts = service.getAll();
        //
        model.addAttribute("accounts",accounts);
        return "list";
    }

    @PutMapping("/account")
    public String updateAccount(@ModelAttribute AccountDto account, Model model) {
//        service.createContact(account);
        System.out.println( "THIS PUT MAPPING WAS CALLED..............");
        return "index";
    }


    @DeleteMapping("/account/{accountID}")
    public String deleteAccount(@PathVariable String accountID, Model model) {

        try {
            service.deleteAccount(accountID);
        } catch (Exception e) {
            return "redirect:/";
        }
        return "redirect:/list";
    }
}
