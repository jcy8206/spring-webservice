package com.jcy.springwebservice.service;

import com.jcy.springwebservice.domain.item.Item;
import com.jcy.springwebservice.repository.Dto.ItemSearchCond;
import com.jcy.springwebservice.repository.Dto.ItemUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item save(Item item);

    void update(Long itemId, ItemUpdateDto updateDto);

    Optional<Item> findById(Long id);

    List<Item> findItems(ItemSearchCond cond);

}
