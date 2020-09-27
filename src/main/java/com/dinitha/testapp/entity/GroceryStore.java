package com.dinitha.testapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "groceryStores")
@Getter
@Setter
public class GroceryStore {

    @Id
    @SequenceGenerator(name="generator", sequenceName="GROCERY_STORE_SEQ",allocationSize=1)
    @GeneratedValue(generator = "generator")
    @Column(name = "grocery_store_id")
    private Long groceryStoreId;

    @Column(name = "name")
    private String name;

    @Transient
    private float mean;

    @Column(name = "description")
    private String description;

    public Long getGroceryStoreId() {
        return groceryStoreId;
    }

    public void setGroceryStoreId(Long groceryStoreId) {
        this.groceryStoreId = groceryStoreId;
    }

    public float getMean() { return mean; }

    public void setMean(float mean) { this.mean = mean; }

}