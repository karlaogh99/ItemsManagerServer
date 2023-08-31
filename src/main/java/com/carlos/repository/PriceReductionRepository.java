package com.carlos.repository;

import com.carlos.model.PriceReduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface PriceReductionRepository extends JpaRepository<PriceReduction,Integer> {
    List<PriceReduction> findByItemIdAndEndDateGreaterThanEqual(int itemId, Date startDate);
    List<PriceReduction> findByItemIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(int itemId, Date endDate, Date startDate);

}
