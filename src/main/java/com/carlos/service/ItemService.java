package com.carlos.service;

import com.carlos.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    public List<Item> getAllItem();
}
