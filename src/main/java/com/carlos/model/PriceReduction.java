package com.carlos.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PriceReduction")
public class PriceReduction {
    @Id
    @Column(name = "priceReduction_id", unique = true, nullable = false )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long priceReduction_id;

    @Column(name = "reducedPrice", nullable = false)
    private Double reducedPrice ;

    @Column(name = "startDate", nullable = false)
    private Date startDate ;
    @Column(name = "endDate", nullable = false)
    private Date endDate ;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    public Long getPriceReduction_id() {
        return priceReduction_id;
    }

    public void setPriceReduction_id(Long priceReduction_id) {
        this.priceReduction_id = priceReduction_id;
    }

    public Double getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(Double reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
