package com.carlos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "item_supplier")
public class ItemSupplier {
    @Id
    @Column(name = "item_supplier_id", unique = true, nullable = false )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int item_supplier_id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    @JsonBackReference(value = "itemsup")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    @JsonIgnore
    private Supplier supplier;

    public int getItem_supplier_id() {
        return item_supplier_id;
    }

    public void setItem_supplier_id(int item_supplier_id) {
        this.item_supplier_id = item_supplier_id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    // Constructor, getters, setters, etc.
}
