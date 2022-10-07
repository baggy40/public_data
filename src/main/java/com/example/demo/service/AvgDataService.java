package com.example.demo.service;

import com.example.demo.entity.Avg_data;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AvgDataService {
    @PersistenceContext
    private final EntityManager entityManager;

    @Transactional
    @Cacheable(value = "Avg_data")
    public void search(){
        StoredProcedureQuery query = this.entityManager.createNamedStoredProcedureQuery("cal_pro_out2");
        query.execute();
        int RESULT = (int) query.getOutputParameterValue("RESULT");
        int tues = (int) query.getOutputParameterValue("tues");
        int fris = (int) query.getOutputParameterValue("fris");
        int mons = (int) query.getOutputParameterValue("mons");

        System.out.println(RESULT);
        System.out.println(tues);
        System.out.println(fris);
        System.out.println(mons);
    }
}
