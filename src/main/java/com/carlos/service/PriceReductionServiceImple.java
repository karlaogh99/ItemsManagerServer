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
    public List<PriceReduction> findByItem_id(int item_id) {
        return priceReductionRepository.findByItem_id(item_id);
    }

    @Override
    public PriceReduction createPriceReduction(PriceReduction priceReduction) {
        return null;
    }

    @Override
    public PriceReduction save(PriceReduction priceReduction) {
        return priceReductionRepository.save(priceReduction);
    }
}
