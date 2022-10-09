package com.example.demo.repository;

import com.example.demo.dto.Avg_dataDto;
import com.example.demo.entity.Avg_data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AvgDataRepository extends JpaRepository<Avg_data, Long> {

    @Query(value="select * from avg_data i where i.year_value_1 = :year_value",
    nativeQuery = true)
    Avg_data findByYear_value_1(int year_value);
}
