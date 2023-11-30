package com.example.lost_and_found;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.lost_and_found.Entities.Item;

import org.springframework.ui.Model;

@Controller
public class LostAndFoundController {
    private final LostAndFoundService lostAndFoundService;

    public LostAndFoundController(LostAndFoundService lostAndFoundService) {
        this.lostAndFoundService = lostAndFoundService;
    }

    @GetMapping("/")
    public String index(Model model) {
        Item item = lostAndFoundService.getItemByID((long)1);

        if (item != null) {
            model.addAttribute("item.itemName", item.GetItemName());
            model.addAttribute("item.description", item.GetDescription());
        } else {
            // Обробка винятку, перенаправлення на сторінку з помилкою.
            return "error";
        }
    
        return "index";
    }   

}
