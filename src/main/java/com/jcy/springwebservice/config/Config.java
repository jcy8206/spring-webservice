package com.jcy.springwebservice.config;

import com.jcy.springwebservice.repository.ItemRepository;
import com.jcy.springwebservice.repository.ItemRepositoryD;
import com.jcy.springwebservice.service.ItemService;
import com.jcy.springwebservice.service.ItemServiceC;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class Config {

    private EntityManager em;
    private final ItemRepository itemRepository;

    @Bean
    public ItemService itemService() {
        return new ItemServiceC(itemRepository, itemRepositoryD());
    }

    @Bean
    public ItemRepositoryD itemRepositoryD() {
        return new ItemRepositoryD(em);
    }
}
