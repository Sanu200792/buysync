package com.buysync.buysynccore.repository;

import com.buysync.buysynccore.domain.ItemQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemQuantityRepository extends JpaRepository<ItemQuantity, String> {
}
