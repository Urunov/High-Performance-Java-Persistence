package com.urunov.rest.repository;

import com.urunov.rest.model.info.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressResource extends JpaRepository<Address, Long> {
}
