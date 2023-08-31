package com.carlos.service;

import com.carlos.model.Item;
import com.carlos.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImple implements ItemService {
    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> getAllItem() {
        try {
        return itemRepository.findAll();
    }catch (Exception e){
        System.out.println(e);
        throw new RuntimeException(e);
    }
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Optional<Item> findById(int itemId) {
        return itemRepository.findById(itemId);
    }
}
