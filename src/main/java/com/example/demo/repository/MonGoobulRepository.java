package com.example.demo.repository;

import com.example.demo.entity.MonGoobulMoveCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MonGoobulRepository extends JpaRepository<MonGoobulMoveCopy, Long> {

    @Query(value = "SELECT * FROM mon_goobul_move_copy WHERE AREA like '종로구%'",
            nativeQuery = true)
    List<MonGoobulMoveCopy> findAndJongro();
}
