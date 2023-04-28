package com.AtoZ.abc.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Store {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @OneToMany(mappedBy = "store")
    private List<Item> items = new ArrayList<>();

    private String name;
}
