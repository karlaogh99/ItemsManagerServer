package com.carlos.service;

import com.carlos.model.PriceReduction;
import com.carlos.repository.PriceReductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class PriceReductionServiceImple implements PriceReductionService {
    @Autowired
    private PriceReductionRepository priceReductionRepository;
    @Override
    public PriceReduction createPriceReduction(PriceReduction priceReduction) {
        int itemId = priceReduction.getItem().getItem_id();
        Date startDate = priceReduction.getStartDate();
        Date endDate = priceReduction.getEndDate();

        List<PriceReduction> overlappingPriceReductions = priceReductionRepository.findByItemIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(itemId, endDate, startDate);
        if (!overlappingPriceReductions.isEmpty()) {
            throw new IllegalArgumentException("An active price reduction already exists for the selected date range.");
        }


        return priceReductionRepository.save(priceReduction);
    }
}
