package com.AtoZ.abc.domain;

import com.AtoZ.abc.domain.order.Order;
import com.AtoZ.abc.dto.UserDto;
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

    public void updateUser(UserDto.UserUpdateDto userUpdateDto) {
        name = userUpdateDto.getName();
        email = userUpdateDto.getEmail();
    }

}
