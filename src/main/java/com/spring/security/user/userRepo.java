package com.spring.security.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.username = :username")
    public User getUserByUsername(@Param("username") String username);

}
