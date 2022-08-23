package com.jcy.springwebservice.service;

import com.jcy.springwebservice.domain.item.Item;
import com.jcy.springwebservice.repository.Dto.ItemSearchCond;
import com.jcy.springwebservice.repository.Dto.ItemUpdateDto;
import com.jcy.springwebservice.repository.ItemRepository;
import com.jcy.springwebservice.repository.ItemRepositoryD;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemServiceC implements ItemService{

    private final ItemRepository itemRepository;
    private final ItemRepositoryD itemRepositoryD;

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void update(Long itemId, ItemUpdateDto updateDto) {
        Item findItem = itemRepository.findById(itemId).orElseThrow();
        findItem.setItemName(updateDto.getItemName());
        findItem.setPrice(updateDto.getPrice());
        findItem.setQuantity(updateDto.getQuantity());
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public List<Item> findItems(ItemSearchCond cond) {
        return itemRepositoryD.findAll(cond);
    }
}
