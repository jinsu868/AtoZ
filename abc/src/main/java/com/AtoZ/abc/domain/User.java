package com.AtoZ.abc.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class User {

    @Id @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "user")
    List<Order> orders = new ArrayList<>();

    @NotEmpty
    private String loginId;
    @NotEmpty
    private String password;
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;

    @Embedded
    private Address address;
}
