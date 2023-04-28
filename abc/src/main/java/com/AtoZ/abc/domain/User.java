package com.AtoZ.abc.domain;

import jakarta.persistence.*;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
public class User extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @OneToMany(mappedBy = "user")
    List<Order> orders = new ArrayList<>();

    private String loginId;
    private String password;
    private String name;
    private String email;

    @Embedded
    private Address address;
}
