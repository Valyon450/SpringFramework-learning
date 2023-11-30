package com.example.lost_and_found.models;

// Контактна інформація
public class ContactInfo {
    private String _surName;
    private String _name;
    private String _patronymic;
    private String _email;
    private String _phone;

    public ContactInfo()
    {
        
    }

    public ContactInfo(String surName, String name, String patronymic, String email, String phone)
    {
        _surName = surName;
        _name = name;
        _patronymic = patronymic;
        _email = email;
        _phone = phone;
    }

    // get, set Прізвище
    public String GetSurName()
    {
        return _surName;
    }

    public void SetSurName(String surName)
    {
        _surName = surName;
    }

    // get, set Ім'я
    public String GetName()
    {
        return _name;
    }

    public void SetName(String name)
    {
        _name = name;
    }

    // get, set Ім'я по батькові
    public String GetPatronymic()
    {
        return _patronymic;
    }

    public void SetPatronymic(String patronymic)
    {
        _patronymic = patronymic;
    }

    // get, set Пошта
    public String GetEmail()
    {
        return _email;
    }

    public void SetEmail(String email)
    {
        _email = email;
    }

    // get, set Телефон
    public String GetPhone()
    {
        return _phone;
    }

    public void SetPhone(String phone)
    {
        _phone = phone;
    }
}