package com.example.lost_and_found;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lost_and_found.Entities.Item;

@Service
public class LostAndFoundService {
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
    public void removeItem(Item item) {
        lostAndFoundRepositoryFake.removeItem(item);
    }
}
