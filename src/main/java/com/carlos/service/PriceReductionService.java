package com.carlos.service;

import com.carlos.model.PriceReduction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PriceReductionService {
    public List<PriceReduction> findByItem_id(int item_id);
    public PriceReduction createPriceReduction(PriceReduction priceReduction);
    public PriceReduction save(PriceReduction priceReduction) ;
}
