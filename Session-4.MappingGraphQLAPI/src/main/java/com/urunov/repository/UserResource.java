package com.urunov.repository;

import com.urunov.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResource extends JpaRepository<User, Long> {
}
