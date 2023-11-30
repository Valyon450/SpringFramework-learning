package com.example.lost_and_found.Entities;

// Ключові слова
public class Keyword {
    private String _word;

    public Keyword()
    {

    }

    public Keyword(String word)
    {
        _word = word;
    }

    // get, set Ключове слово
    public String GetKeyword()
    {
        return _word;
    }

    public void SetKeyword(String word)
    {
        _word = word;
    }
}