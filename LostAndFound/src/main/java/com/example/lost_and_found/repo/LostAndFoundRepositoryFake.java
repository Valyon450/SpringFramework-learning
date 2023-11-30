package com.example.lost_and_found.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lost_and_found.models.ContactInfo;
import com.example.lost_and_found.models.Description;
import com.example.lost_and_found.models.Item;

@Repository
public class LostAndFoundRepositoryFake {
    private final List<Item> _items = new ArrayList<>();
    
    public LostAndFoundRepositoryFake() {
        initializeData();
    }

    public List<Item> getAllItems() {       

        return _items;        
    }

    public Item getItemByID(Long id) {
        for (Item item : _items) {
            if (item.GetID() == id)
            return item;
        }
        
        return new Item();
    }

    public void addItem(Item item) {
        _items.add(item);
    }

    public void removeItem(Long id) {
        _items.remove(getItemByID(id));
    }

    private void initializeData() {
        ContactInfo contactInfo = new ContactInfo("Іванов", "Сергій", "Володимирович", "sergiv@gmail.com", "+380673842913");

        Description description = new Description("Знайдено ключі в парку біля альтанки");
        
        List<String> keywords = new ArrayList<>();
        keywords.add("ключі");
        keywords.add("парк");

        Item item = new Item((long) 1, "Ключі", description, keywords, contactInfo);

        _items.add(item);
    }
}
