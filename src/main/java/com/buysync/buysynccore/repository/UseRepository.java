package com.buysync.buysynccore.repository;

import com.buysync.buysynccore.domain.Use;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseRepository extends JpaRepository<Use, String> {
}
