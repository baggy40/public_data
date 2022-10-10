package com.example.demo.repository;

import com.example.demo.entity.QSellngQq;
import com.example.demo.entity.SellngQq;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SearchQueryRepository {

    @PersistenceContext
    EntityManager em;
    public List<SellngQq> findSearFun(String year_value, String gubun_value,
                            String store_value, String item_value1) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QSellngQq qSellngQq = QSellngQq.sellngQq;
        List<SellngQq> sellngQqList = null;

        BooleanBuilder builder = new BooleanBuilder();

        if(!StringUtils.isEmpty(year_value)){
            builder.and(qSellngQq.STDR_YY_CD_2.eq(year_value));
        }
        if(!StringUtils.isEmpty(gubun_value)){
            builder.and(qSellngQq.TRDAR_CD_6.eq(gubun_value));;
        }
        if(!StringUtils.isEmpty(store_value)){
            builder.and(qSellngQq.SVC_INDUTY_CD_8.eq(store_value));
        }


        if(item_value1.equals("old_sell")){

            sellngQqList = queryFactory.select(Projections.fields(SellngQq.class,
                            qSellngQq.id,
                            qSellngQq.STDR_YY_CD_2,
                            qSellngQq.TRDAR_CD_NM_7,
                            qSellngQq.SVC_INDUTY_CD_NM_9,
                            qSellngQq.AGRDE_10_SELNG_AMT_29,
                            qSellngQq.AGRDE_20_SELNG_AMT_30,
                            qSellngQq.AGRDE_30_SELNG_AMT_31,
                            qSellngQq.AGRDE_40_SELNG_AMT_32,
                            qSellngQq.AGRDE_50_SELNG_AMT_33,
                            qSellngQq.AGRDE_60_ABOVE_SELNG_AMT_34
                    ))
                    .from(qSellngQq)
                    .where(builder)
                    .fetch();
        }else if(item_value1.equals("sex_sell")){
            sellngQqList = queryFactory.select(Projections.fields(SellngQq.class,
                            qSellngQq.id,
                            qSellngQq.STDR_YY_CD_2,
                            qSellngQq.TRDAR_CD_NM_7,
                            qSellngQq.SVC_INDUTY_CD_NM_9,
                            qSellngQq.ML_SELNG_AMT_27,
                            qSellngQq.FML_SELNG_AMT_28,
                            qSellngQq.WKEND_SELNG_AMT_13,
                            qSellngQq.MDWK_SELNG_AMT_12
                    ))
                    .from(qSellngQq)
                    .where(builder)
                    .fetch();
        }else if(item_value1.equals("part_sell")){
            sellngQqList = queryFactory.select(Projections.fields(SellngQq.class,
                            qSellngQq.id,
                            qSellngQq.STDR_YY_CD_2,
                            qSellngQq.TRDAR_CD_NM_7,
                            qSellngQq.SVC_INDUTY_CD_NM_9,
                            qSellngQq.STOR_CO_35,
                            qSellngQq.THSMON_SELNG_AMT_10,
                            qSellngQq.THSMON_SELNG_CO_11
                    ))
                    .from(qSellngQq)
                    .where(builder)
                    .fetch();
        }else if(item_value1.equals("day_of_week")){
            sellngQqList = queryFactory.select(Projections.fields(SellngQq.class,
                            qSellngQq.id,
                            qSellngQq.STDR_YY_CD_2,
                            qSellngQq.TRDAR_CD_NM_7,
                            qSellngQq.SVC_INDUTY_CD_NM_9,
                            qSellngQq.MON_SELNG_AMT_14,
                            qSellngQq.TUES_SELNG_AMT_15,
                            qSellngQq.WED_SELNG_AMT_16,
                            qSellngQq.THUR_SELNG_AMT_17,
                            qSellngQq.FRI_SELNG_AMT_18,
                            qSellngQq.SAT_SELNG_AMT_19,
                            qSellngQq.SUN_SELNG_AMT_20
                    ))
                    .from(qSellngQq)
                    .where(builder)
                    .fetch();
        }else if(item_value1.equals("time_of_sell")){
            sellngQqList = queryFactory.select(Projections.fields(SellngQq.class,
                            qSellngQq.id,
                            qSellngQq.STDR_YY_CD_2,
                            qSellngQq.TRDAR_CD_NM_7,
                            qSellngQq.SVC_INDUTY_CD_NM_9,
                            qSellngQq.TMZON_00_06_SELNG_AMT_21,
                            qSellngQq.TMZON_06_11_SELNG_AMT_22,
                            qSellngQq.TMZON_11_14_SELNG_AMT_23,
                            qSellngQq.TMZON_14_17_SELNG_AMT_24,
                            qSellngQq.TMZON_17_21_SELNG_AMT_25,
                            qSellngQq.TMZON_21_24_SELNG_AMT_26
                    ))
                    .from(qSellngQq)
                    .where(builder)
                    .fetch();
        }

        /*for(SellngQq sellngQq : sellngQqList){
            System.out.println(sellngQq.toString());
        }*/

        return sellngQqList;
    }

}
