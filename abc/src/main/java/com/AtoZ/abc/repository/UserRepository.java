package com.AtoZ.abc.repository;

import com.AtoZ.abc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(
            "select u from User u join fetch u.orders o where u.id = :userId"
    )
    User findUserWithOrder(Long userId);
}
