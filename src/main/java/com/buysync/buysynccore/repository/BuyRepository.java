package com.buysync.buysynccore.repository;

import com.buysync.buysynccore.domain.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyRepository extends JpaRepository<Buy, String> {
}
