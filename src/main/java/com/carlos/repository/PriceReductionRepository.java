package com.carlos.repository;

import com.carlos.model.PriceReduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface PriceReductionRepository extends JpaRepository<PriceReduction,Integer> {
    @Query("SELECT pr FROM PriceReduction pr WHERE pr.item.item_id = :itemId")
    public List<PriceReduction> findByItem_id( @Param("itemId") int itemId);

}
