package com.example.lost_and_found;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lost_and_found.Entities.ContactInfo;
import com.example.lost_and_found.Entities.Description;
import com.example.lost_and_found.Entities.Item;
import com.example.lost_and_found.Entities.Keyword;

@Repository
public class LostAndFoundRepositoryFake {
    private final List<Item> items;

    public LostAndFoundRepositoryFake()
    {
        items = new ArrayList<>();

        ContactInfo contactInfo = new ContactInfo("Іванов", "Сергій", "Володимирович", "sergiv@gmail.com", "+380673842913");

        Description description = new Description("Знайдено ключі у парку біля альтанки");

        Keyword keyword1 = new Keyword("ключі");
        Keyword keyword2 = new Keyword("парк");
        List<String> keywords = new ArrayList<>();
        keywords.add(keyword1.GetKeyword());
        keywords.add(keyword2.GetKeyword());

        Item item = new Item((long) 1, "", description, keywords, contactInfo);

        items.add(item);
    }
    
    public List<Item> getAllItems() {
        return items;
    }

    public Item getItemByID(Long id) {
        for (Item item : items) {
            if (item.GetID() == id)
            return item;
        }
        return new Item();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
