package com.dinitha.testapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_comments")
@Getter
@Setter
public class UserComment {

    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id")
    private Long id;


    @Column(name = "grocery_id")
    private Long groceryId;

    @Column(name = "comments")
    private String comments;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getGroceryId() { return groceryId; }

    public void setGroceryId(Long groceryId) { this.groceryId = groceryId; }

    public String getComments() { return comments; }

    public void setComments(String comments) { this.comments = comments; }
}
