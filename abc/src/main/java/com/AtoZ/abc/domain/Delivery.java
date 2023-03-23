package com.AtoZ.abc.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Delivery extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
