package com.carlos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PriceReduction")
public class PriceReduction {
    @Id
    @Column(name = "reduction_id", unique = true, nullable = false )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reduction_id;

    @Column(name = "reduced_price", nullable = false)
    private Double reduced_price ;

    @Column(name = "start_date", nullable = false)
    private Date start_date ;
    @Column(name = "end_date", nullable = false)
    private Date end_date ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id", nullable = false)
    @JsonBackReference(value = "priceReductions")


    private Item item;

    public int getPriceReduction_id() {
        return reduction_id;
    }

    public void setPriceReduction_id(int priceReduction_id) {
        this.reduction_id = priceReduction_id;
    }

    public Double getReducedPrice() {
        return reduced_price;
    }

    public void setReducedPrice(Double reducedPrice) {
        this.reduced_price = reducedPrice;
    }

    public Date getStartDate() {
        return start_date;
    }

    public void setStartDate(Date startDate) {
        this.start_date = startDate;
    }

    public Date getEndDate() {
        return end_date;
    }

    public void setEndDate(Date endDate) {
        this.end_date = endDate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
