package com.example.lost_and_found.Entities;

// Опис знахідки
public class Description {
    private String _detailsText;

    public Description()
    {
        
    }

    public Description(String detailsText)
    {
        _detailsText = detailsText;
    }

    // get, set Телефон
    public String GetDescription()
    {
        return _detailsText;
    }

    public void SetDescription(String detailsText)
    {
        _detailsText = detailsText;
    }
}