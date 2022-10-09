package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class SellngQq extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //저장한 년도
    private String year_value_1;

    //기준 년 코드
    private String STDR_YY_CD_2;
    //기준 분기 코드
    private String STDR_QU_CD_3;
    //상권 구분 코드
    private String TRDAR_SE_CD_4;
    //상권 구분 코드명
    private String TRDAR_SE_CD_NM_5;
    //상권 코드
    private String TRDAR_CD_6;
    //상권 코드명
    private String TRDAR_CD_NM_7;
    //서비스 업종 코드
    private String SVC_INDUTY_CD_8;
    //서비스 업종 코드명
    private String SVC_INDUTY_CD_NM_9;
    //분기당 매출 금액
    private String THSMON_SELNG_AMT_10;
    //분기당 매출 건수
    private String THSMON_SELNG_CO_11;
    //주중 매출 금액
    private String MDWK_SELNG_AMT_12;
    //주말 매출 금액
    private String WKEND_SELNG_AMT_13;
    //월요일 매출 금액
    private String MON_SELNG_AMT_14;
    //화요일 매출 금액
    private String TUES_SELNG_AMT_15;
    //수요일 매출 금액
    private String WED_SELNG_AMT_16;
    //목요일 매출 금액
    private String THUR_SELNG_AMT_17;
    //금요일 매출 금액
    private String FRI_SELNG_AMT_18;
    //토요일 매출 금액
    private String SAT_SELNG_AMT_19;
    //일요일 매출 금액
    private String SUN_SELNG_AMT_20;
    
    //시간대 00-06 매출
    private String TMZON_00_06_SELNG_AMT_21;
    //시간대 06-11 매출
    private String TMZON_06_11_SELNG_AMT_22;
    //시간대 11-14 매출
    private String TMZON_11_14_SELNG_AMT_23;
    //시간대 14-17 매출
    private String TMZON_14_17_SELNG_AMT_24;
    //시간대 17-21 매출
    private String TMZON_17_21_SELNG_AMT_25;
    //시간대 21-24 매출
    private String TMZON_21_24_SELNG_AMT_26;
    //남성 매출 금액
    private String ML_SELNG_AMT_27;
    //여성 매출 금액
    private String FML_SELNG_AMT_28;
    //연령대 10 매출
    private String AGRDE_10_SELNG_AMT_29;
    //연령대 20 매출
    private String AGRDE_20_SELNG_AMT_30;
    //연령대 30 매출
    private String AGRDE_30_SELNG_AMT_31;
    //연령대 40 매출
    private String AGRDE_40_SELNG_AMT_32;
    //연령대 50 매출
    private String AGRDE_50_SELNG_AMT_33;
    //연령대 60이상 매출
    private String AGRDE_60_ABOVE_SELNG_AMT_34;
    //점포수
    private String STOR_CO_35;
    
}
