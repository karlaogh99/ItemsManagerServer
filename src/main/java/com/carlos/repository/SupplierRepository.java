package com.carlos.repository;

import com.carlos.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    @Query(nativeQuery = true, value =
            "SELECT s.name, i.description, i.price " +
            "FROM supplier s " +
            "INNER JOIN item_supplier isup ON s.supplier_id = isup.supplier_id " +
            "INNER JOIN item i ON isup.item_id = i.item_id " +
            //"LEFT JOIN price_reduction pr ON i.item_id = pr.item_id " +
                    "WHERE i.price = ( " +
                    "SELECT MIN(i2.price) " +
                    "FROM item i2 " +
                    "INNER JOIN item_supplier isup2 ON i2.item_id = isup2.item_id " +
                    "WHERE isup2.supplier_id = s.supplier_id )")
    List<Object[]> findCheapestItemsPerSupplier();
    @Query(nativeQuery = true, value =
        "SELECT DISTINCT s.name " +
                "FROM supplier s " +
                "INNER JOIN item_supplier isup ON s.supplier_id = isup.supplier_id " +
                "INNER JOIN item i ON isup.item_id = i.item_id " +
                "INNER JOIN price_reduction pr ON i.item_id = pr.item_id ")
    List<Object[]> suppliers_Associated_with_Items();
}
