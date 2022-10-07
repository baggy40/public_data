package com.example.demo.repository;

import com.example.demo.entity.SellngQq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface SellingQqRepository extends JpaRepository<SellngQq, Long> ,
        QuerydslPredicateExecutor<SellngQq>, SellingRepositorySearch {
}
