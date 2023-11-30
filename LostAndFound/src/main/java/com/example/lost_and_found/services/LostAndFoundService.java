package com.example.lost_and_found.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.lost_and_found.models.Item;
import com.example.lost_and_found.repo.LostAndFoundRepositoryFake;

@Service
public class LostAndFoundService {
    @Autowired
    private final LostAndFoundRepositoryFake lostAndFoundRepositoryFake;

    public LostAndFoundService(LostAndFoundRepositoryFake lostAndFoundRepositoryFake) {
        this.lostAndFoundRepositoryFake = lostAndFoundRepositoryFake;
    }

    // Метод для отримання всіх знахідок
    public List<Item> getAllItems() {
        
        return lostAndFoundRepositoryFake.getAllItems();
    }

    // Метод для отримання знахідки за ID
    public Item getItemByID(Long id) {
        return lostAndFoundRepositoryFake.getItemByID(id);
    }

    // Метод для додавання нової знахідки
    public void addItem(Item item) {
        lostAndFoundRepositoryFake.addItem(item);
    }

    // Метод для видалення знахідки
    public void removeItem(Long id) {
        lostAndFoundRepositoryFake.removeItem(id);
    }
}
