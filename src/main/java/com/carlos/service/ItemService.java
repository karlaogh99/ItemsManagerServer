package com.carlos.service;

import com.carlos.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ItemService {
    public List<Item> getAllItem();

    public Item save(Item item);

    public Optional<Item> findById(int itemId);
}
