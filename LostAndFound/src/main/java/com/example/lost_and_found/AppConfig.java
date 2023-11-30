package com.example.lost_and_found;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.lost_and_found.repo.LostAndFoundRepositoryFake;
import com.example.lost_and_found.services.LostAndFoundService;

// Конфігурація бінів Spring
@Configuration
public class AppConfig {

    // Бін типу singleton
    @Bean
    public LostAndFoundService itemServiceSingleton(LostAndFoundRepositoryFake itemRepository) {
        return new LostAndFoundService(itemRepository);
    }

    // Бін типу prototype
    @Bean
    @Scope("prototype")
    public LostAndFoundService itemServicePrototype(LostAndFoundRepositoryFake itemRepository) {
        return new LostAndFoundService(itemRepository);
    }
}
