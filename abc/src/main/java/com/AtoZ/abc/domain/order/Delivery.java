package com.AtoZ.abc.domain.order;

import com.AtoZ.abc.domain.Address;
import com.AtoZ.abc.domain.BaseEntity;
import com.AtoZ.abc.domain.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Delivery extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
