package com.example.demo.service;

import com.example.demo.entity.CiDoBetweenMoveCopy;
import com.example.demo.entity.MonGoobulMoveCopy;
import com.example.demo.repository.MonGoobulRepository;
import com.example.demo.repository.PopularRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PopularService {

    private final PopularRepository popularRepository;

    private final MonGoobulRepository monGoobulRepository;

    public List<CiDoBetweenMoveCopy> popularSearch(){

        List<CiDoBetweenMoveCopy> ciDoBetweenList = popularRepository.findAll();

        return ciDoBetweenList;
    }
    public  List<CiDoBetweenMoveCopy>  popularWhere(){

        List<CiDoBetweenMoveCopy> ciDoBetweenMoveCopy = popularRepository.findAndWhere();
        return ciDoBetweenMoveCopy;
    }

    public List<MonGoobulMoveCopy> findAndJongro(){
        List<MonGoobulMoveCopy> monGoobulMoveCopies = monGoobulRepository.findAndJongro();
        return monGoobulMoveCopies;
    }
}
