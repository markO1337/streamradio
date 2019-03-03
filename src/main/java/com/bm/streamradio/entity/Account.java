package com.bm.streamradio.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String user;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Category> categories;

    public void addCategory(Category category) {
        if(categories == null)
            categories = new ArrayList<>();
        this.categories.add(category);
    }
}
