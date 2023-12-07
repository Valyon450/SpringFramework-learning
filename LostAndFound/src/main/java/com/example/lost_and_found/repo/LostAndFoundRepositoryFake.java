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

    public List<Item> getItemsByKeyWords(String keywords){
        List<Item> findings = new ArrayList<>();
        for(Item item : _items){
            if(item.GetKeywords().contains(keywords)){
                findings.add(item);
            }
        }
        return findings;
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
        // Створюємо та додаємо першу знахідку
        ContactInfo contactInfo = new ContactInfo("Іванов", "Сергій", "Володимирович", "sergiv@gmail.com", "+380673842913");

        Description description = new Description("Знайдено ключі в парку біля альтанки");
        
        List<String> keywords = new ArrayList<>();
        keywords.add("ключі");
        keywords.add("парк");

        Long id = (long) (_items.size() + 1);

        Item item = new Item(id, "Ключі", description, keywords, contactInfo);

        _items.add(item);

        // Створюємо та додаємо другу знахідку
        contactInfo = new ContactInfo("Григоренко", "Антон", "Юрійович", "grygant@gmail.com", "+380973429516");

        description = new Description("Біля ТЦ \"Оазис\" знайдено шкіряний гаманець");
        
        keywords = new ArrayList<>();
        keywords.add("гаманець");
        keywords.add("оазис");

        id = (long) (_items.size() + 1);

        item = new Item(id, "Гаманець", description, keywords, contactInfo);

        _items.add(item);

        // Створюємо та додаємо третю знахідку
        contactInfo = new ContactInfo("Карпенко", "Юлія", "Миколаївна", "karpjul@gmail.com", "+380684387249");

        description = new Description("Знайдено телефон біля дитячого майданчика");
        
        keywords = new ArrayList<>();
        keywords.add("майданчик");
        keywords.add("телефон");

        id = (long) (_items.size() + 1);

        item = new Item(id, "Телефон", description, keywords, contactInfo);

        _items.add(item);
    }
}
