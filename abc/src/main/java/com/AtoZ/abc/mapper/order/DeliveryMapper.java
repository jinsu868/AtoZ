package com.AtoZ.abc.mapper.order;

import com.AtoZ.abc.domain.Address;
import com.AtoZ.abc.domain.DeliveryStatus;
import com.AtoZ.abc.domain.order.Delivery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {

    default Delivery AddressToDelivery(Address address) {
        return Delivery.builder()
                .address(address)
                .status(DeliveryStatus.READY)
                .build();
    }
}
