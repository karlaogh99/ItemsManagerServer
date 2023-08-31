package com.carlos.repository;

import com.carlos.model.ItemSupplier;
import com.carlos.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemSupplierRepository extends JpaRepository<ItemSupplier, Integer> {
    @Query("SELECT isup FROM ItemSupplier isup WHERE isup.item.item_id = :itemId")
    List<ItemSupplier> findByItemItemId(@Param("itemId") int itemId);
}
