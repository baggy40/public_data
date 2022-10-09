package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avg_dataDto {

    private Long id;
    private int year;
    private int tues;
    private int fris;
    private int mons;
    //분기당 매출 금액
    private int THSMON_SELNG_AMT_10;
    //분기당 매출 건수
    private int THSMON_SELNG_CO_11;
    //주중 매출 금액
    private int MDWK_SELNG_AMT_12;
    //주말 매출 금액
    private int WKEND_SELNG_AMT_13;
    //월요일 매출 금액
    private int MON_SELNG_AMT_14;
    //화요일 매출 금액
    private int TUES_SELNG_AMT_15;
    //수요일 매출 금액
    private int WED_SELNG_AMT_16;
    //목요일 매출 금액
    private int THUR_SELNG_AMT_17;
    //금요일 매출 금액
    private int FRI_SELNG_AMT_18;
    //토요일 매출 금액
    private int SAT_SELNG_AMT_19;
    //일요일 매출 금액
    private int SUN_SELNG_AMT_20;
    //시간대 00-06 매출
    private int TMZON_00_06_SELNG_AMT_21;
    //시간대 06-11 매출
    private int TMZON_06_11_SELNG_AMT_22;
    //시간대 11-14 매출
    private int TMZON_11_14_SELNG_AMT_23;
    //시간대 14-17 매출
    private int TMZON_14_17_SELNG_AMT_24;
    //시간대 17-21 매출
    private int TMZON_17_21_SELNG_AMT_25;
    //시간대 21-24 매출
    private int TMZON_21_24_SELNG_AMT_26;
    //남성 매출 금액
    private int ML_SELNG_AMT_27;
    //여성 매출 금액
    private int FML_SELNG_AMT_28;
    //연령대 10 매출
    private int AGRDE_10_SELNG_AMT_29;
    //연령대 20 매출
    private int AGRDE_20_SELNG_AMT_30;
    //연령대 30 매출
    private int AGRDE_30_SELNG_AMT_31;
    //연령대 40 매출
    private int AGRDE_40_SELNG_AMT_32;
    //연령대 50 매출
    private int AGRDE_50_SELNG_AMT_33;
    //연령대 60이상 매출
    private int AGRDE_60_ABOVE_SELNG_AMT_34;
    //점포수
    private int STOR_CO_35;

}
