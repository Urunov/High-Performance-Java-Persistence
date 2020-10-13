package com.urunov.repository;

import com.urunov.entity.info.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressResource extends JpaRepository<Address, Long> {
}
