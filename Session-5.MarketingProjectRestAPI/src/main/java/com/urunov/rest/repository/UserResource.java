package com.urunov.rest.repository;

import com.urunov.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResource extends JpaRepository<User, Long> {
}
