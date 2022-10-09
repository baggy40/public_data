package com.example.demo.service;

import com.example.demo.entity.Avg_data;
import com.example.demo.repository.AvgDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AvgDataService {

    private final AvgDataRepository avgDataRepository;

    @PersistenceContext
    private final EntityManager entityManager;

    @Transactional
    @Cacheable(value = "Avg_data")
    public List<Avg_data> search(String year){

        StoredProcedureQuery query = this.entityManager.createNamedStoredProcedureQuery("cal_pro_exe");
        query.setParameter("year_num", Integer.parseInt(year));
        query.execute();
        int tues = (int) query.getOutputParameterValue("tues");
        int fris = (int) query.getOutputParameterValue("fris");
        int mons = (int) query.getOutputParameterValue("mons");

        System.out.println("===========year"+ Integer.parseInt(year));

        List<Avg_data> avg_data = new ArrayList<>();
        avg_data = avgDataRepository.findAll();

        //Avg_data avg_data = avgDataRepository.findByYear_value(year);

        return avg_data;
    }
}
