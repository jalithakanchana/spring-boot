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


    @Column(name = "description")
    private String description;
}