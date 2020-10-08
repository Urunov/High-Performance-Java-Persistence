package com.urunov.dataresource;

import com.urunov.input.info.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressResource extends JpaRepository<Address, Long> {
}
