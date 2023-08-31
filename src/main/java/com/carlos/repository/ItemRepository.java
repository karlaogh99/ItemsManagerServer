package com.carlos.repository;

import com.carlos.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    //Optional<Item> findByitem_code(int item_code);
}

