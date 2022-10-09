package com.example.demo.repository;

import com.example.demo.dto.QSellngQqDto;
import com.example.demo.dto.SellngQqDto;
import com.example.demo.dto.SellngSearchDto;
import com.example.demo.entity.QSellngQq;
import com.example.demo.entity.SellngQq;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class SellingRepositorySearchImpl implements SellingRepositorySearch{

    private JPAQueryFactory queryFactory;

    public SellingRepositorySearchImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }

    private BooleanExpression regDtsAfter(String searchDateType){
        LocalDateTime dateTime = LocalDateTime.now();

        if(StringUtils.equals("all",searchDateType) || searchDateType == null){
            return null;
        }else if(StringUtils.equals("1d", searchDateType)){
            dateTime = dateTime.minusDays(1);
        }else if(StringUtils.equals("1w", searchDateType)){
            dateTime = dateTime.minusWeeks(1);
        }

        return QSellngQq.sellngQq.regTime.after(dateTime);
    }

    private BooleanExpression searchByLike(String searchBy, String searchQuery){
        if(StringUtils.equals("TRDAR_SE_CD_NM",searchBy)){
            return QSellngQq.sellngQq.TRDAR_SE_CD_NM_5.like("%"+searchQuery + "%");
        }else if(StringUtils.equals("SVC_INDUTY_CD_NM", searchBy)){
            return QSellngQq.sellngQq.SVC_INDUTY_CD_NM_9.like("%"+searchQuery+"%");
        }
        return null;
    }


    @Override
    public Page<SellngQq> getSellPage(SellngSearchDto sellngSearchDto, Pageable pageable) {
        QueryResults<SellngQq> results = queryFactory
                .selectFrom(QSellngQq.sellngQq)
                .where(regDtsAfter(sellngSearchDto.getSearchDateType()),
                        searchByLike(sellngSearchDto.getSearchBy(),
                                sellngSearchDto.getSearchQuery()))
                .orderBy(QSellngQq.sellngQq.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        List<SellngQq> content = results.getResults();
        long total = results.getTotal();
        return new PageImpl<>(content, pageable, total);
    }

}
