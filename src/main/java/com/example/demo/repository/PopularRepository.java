package com.example.demo.repository;

import com.example.demo.entity.CiDoBetweenMoveCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PopularRepository extends JpaRepository<CiDoBetweenMoveCopy, Long> {

    @Query(value = "SELECT  * FROM ci_do_between_move_copy WHERE ja_chi_gu = '종로구'",
    nativeQuery = true)
    List<CiDoBetweenMoveCopy> findAndWhere();
}
