package com.AtoZ.abc.domain.Item;

import com.AtoZ.abc.domain.Item.Item;
import com.AtoZ.abc.dto.StoreDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @OneToMany(mappedBy = "store")
    private List<Item> items = new ArrayList<>();

    private String name;

    public void updateStore(StoreDto.StoreUpdateDto storeUpdateDto) {
        name = storeUpdateDto.getStoreName();
    }
}
