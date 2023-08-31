package com.carlos.service;

import com.carlos.model.PriceReduction;
import org.springframework.stereotype.Service;

@Service
public interface PriceReductionService {
    public PriceReduction createPriceReduction(PriceReduction priceReduction);
}
