package com.example.lost_and_found.Entities;

import java.util.List;

// Знахідка
public class Item {
    private Long _id;
    private String _itemName;
    private Description _description;
    private List<String> _keywords;
    private ContactInfo _contactInfo;

    public Item()
    {
        
    }

    public Item(Long id, String itemName, Description description, List<String> keywords, ContactInfo contactInfo)
    {
        _id = id;
        _itemName = itemName;
        _description = description;
        _keywords = keywords;
        _contactInfo = contactInfo;
    }

    // get, set ID
    public Long GetID()
    {
        return _id;
    }

    public void SetID(Long id)
    {
        _id = id;
    }

    // get, set Назва
    public String GetItemName()
    {
        return _itemName;
    }

    public void SetItemName(String itemName)
    {
        _itemName = itemName;
    }

    // get, set Опис
    public String GetDescription()
    {
        return _description.GetDescription();
    }

    public void SetDescription(String description)
    {
        _description.SetDescription(description);
    }

    // get, set Ключові слова
    public List<String> GetKeywords()
    {
        return _keywords;
    }

    public void AddKeyword(Keyword keyword)
    {
        _keywords.add(keyword.GetKeyword());
    }

    // get, set Контакти
    // get, set Прізвище
    public String GetSurName()
    {
        return _contactInfo.GetSurName();
    }

    public void SetSurName(String surName)
    {
        _contactInfo.SetSurName(surName);
    }

    // get, set Ім'я
    public String GetName()
    {
        return _contactInfo.GetName();
    }

    public void SetName(String name)
    {
        _contactInfo.SetName(name);
    }

    // get, set Ім'я по батькові
    public String GetPatronymic()
    {
        return _contactInfo.GetPatronymic();
    }

    public void SetPatronymic(String patronymic)
    {
        _contactInfo.SetPatronymic(patronymic);
    }

    // get, set Пошта
    public String GetEmail()
    {
        return _contactInfo.GetEmail();
    }

    public void SetEmail(String email)
    {
        _contactInfo.SetEmail(email);
    }

    // get, set Телефон
    public String GetPhone()
    {
        return _contactInfo.GetPhone();
    }

    public void SetPhone(String phone)
    {
        _contactInfo.SetPhone(phone);
    }
}
