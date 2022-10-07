package com.example.demo.repository;

import com.example.demo.dto.SellngQqDto;
import com.example.demo.dto.SellngSearchDto;
import com.example.demo.entity.SellngQq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SellingRepositorySearch {
    Page<SellngQq> getSellPage(SellngSearchDto sellngSearchDto, Pageable pageable);

    //Page<SellngQqDto> getMainSellpage(SellngSearchDto sellngSearchDto, Pageable pageable);
}
