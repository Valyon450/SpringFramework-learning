package com.example.lost_and_found.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lost_and_found.models.ContactInfo;
import com.example.lost_and_found.models.Description;
import com.example.lost_and_found.models.Item;
import com.example.lost_and_found.services.LostAndFoundService;


import org.springframework.ui.Model;

@Controller
public class LostAndFoundController {
    @Autowired
    private final LostAndFoundService lostAndFoundService;

    public LostAndFoundController(LostAndFoundService lostAndFoundService) {
        this.lostAndFoundService = lostAndFoundService;
    }

    @GetMapping("/")
    public String lostAndFoundMain(Model model) {
        
        List<Item> items = lostAndFoundService.getAllItems();
        
        if (items != null) {
            model.addAttribute("items", items);
            return "lostAndFoundMain";
        } else {
            // Обробка винятку, перенаправлення на сторінку з помилкою.
            return "error";
        }        
    }

    @GetMapping("/addItem")
    public String addItem(Model model) {
        
        return "addItem";
    }

    @PostMapping("/addItem")
    public String addItemPost(@RequestParam String nameItem, @RequestParam String description, @RequestParam String keywords, @RequestParam String surName, @RequestParam String name, @RequestParam String patronymic, @RequestParam String email, @RequestParam String phone, Model model) {

        ContactInfo contactInfo = new ContactInfo(surName, name, patronymic, email, phone);

        Description descriptionItem = new Description(description);
        
        List<String> keywordsList = Arrays.asList(keywords.split(" "));
        
        Long id = (long) (lostAndFoundService.getAllItems().size() + 1);
        Item item = new Item(id, nameItem, descriptionItem, keywordsList, contactInfo);

        lostAndFoundService.addItem(item);

        return "redirect:/"; // Перенаправлення на головну сторінку
    }


    @GetMapping("/removeItem")
    public String removeItem(Model model) {       
        List<Item> items = lostAndFoundService.getAllItems();
        if (items != null) {
            model.addAttribute("items", items);
            
            return "removeItem";
        } else {
            // Обробка винятку, перенаправлення на сторінку з помилкою.
            return "error";
        }
    }

    @PostMapping("/removeItemId")
    public String removeItem(Model model, @RequestParam Long searchById) {  
        Long id = searchById;     
        Item items = lostAndFoundService.getItemByID(id);
        System.out.println(items);
        if (items != null) {
            model.addAttribute("items", items);
            lostAndFoundService.removeItem(id);
            return "removeItem";
        } else {
            // Обробка винятку, перенаправлення на сторінку з помилкою.
            return "error";
        }
    }

    @PostMapping("/removeItem")
    public String removeItem(@RequestParam Long itemId) {
        lostAndFoundService.removeItem(itemId);
        return "redirect:/"; // Перенаправлення на головну сторінку
    }

    @GetMapping("/searchItem")
    public String searchItem(@RequestParam("keyword") String searchByKeyWord, Model model){
        String keyword = searchByKeyWord;
        if (keyword != null) {
            List<Item> findings = lostAndFoundService.getItemByKeyWord(keyword);            
            if (findings != null) {
                model.addAttribute("keyword", keyword);
                model.addAttribute("items", findings);
            }
            else{
                List<Item> items = lostAndFoundService.getAllItems();
                model.addAttribute("items", items);}
        }
        return "searchItem";
    }

    @GetMapping("/itemPage/{code}")
    public String itemPage(@PathVariable Long code, Model model){
        Long id = code;     
        Item items = lostAndFoundService.getItemByID(id);
        if (items != null) {
            model.addAttribute("item", items);
            return "itemPage";
        } else {
            // Обробка винятку, перенаправлення на сторінку з помилкою.
            return "error";
        }
    }
}
