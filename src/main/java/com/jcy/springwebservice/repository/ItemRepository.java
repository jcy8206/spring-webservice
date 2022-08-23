package com.jcy.springwebservice.repository;

import com.jcy.springwebservice.domain.item.Item;
import com.jcy.springwebservice.repository.Dto.ItemUpdateDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
