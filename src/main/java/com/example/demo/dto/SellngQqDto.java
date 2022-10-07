package com.example.demo.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SellngQqDto {

    private Long id;

    //저장한 년도
    private String year_value;

    //기준 년 코드
    private String STDR_YY_CD;
    //기준 분기 코드
    private String STDR_QU_CD;
    //상권 구분 코드
    private String TRDAR_SE_CD;
    //상권 구분 코드명
    private String TRDAR_SE_CD_NM;
    //상권 코드
    private String TRDAR_CD;
    //상권 코드명
    private String TRDAR_CD_NM;
    //서비스 업종 코드
    private String SVC_INDUTY_CD;
    //서비스 업종 코드명
    private String SVC_INDUTY_CD_NM;
    //분기당 매출 금액
    private String THSMON_SELNG_AMT;
    //분기당 매출 건수
    private String THSMON_SELNG_CO;
    //주중 매출 금액
    private String MDWK_SELNG_AMT;
    //주말 매출 금액
    private String WKEND_SELNG_AMT;
    //월요일 매출 금액
    private String MON_SELNG_AMT;
    //화요일 매출 금액
    private String TUES_SELNG_AMT;
    //수요일 매출 금액
    private String WED_SELNG_AMT;
    //목요일 매출 금액
    private String THUR_SELNG_AMT;
    //금요일 매출 금액
    private String FRI_SELNG_AMT;
    //토요일 매출 금액
    private String SAT_SELNG_AMT;
    //일요일 매출 금액
    private String SUN_SELNG_AMT;

    //시간대 00-06 매출
    private String TMZON_00_06_SELNG_AMT;
    //시간대 06-11 매출
    private String TMZON_06_11_SELNG_AMT;
    //시간대 11-14 매출
    private String TMZON_11_14_SELNG_AMT;
    //시간대 14-17 매출
    private String TMZON_14_17_SELNG_AMT;
    //시간대 17-21 매출
    private String TMZON_17_21_SELNG_AMT;
    //시간대 21-24 매출
    private String TMZON_21_24_SELNG_AMT;
    //남성 매출 금액
    private String ML_SELNG_AMT;
    //여성 매출 금액
    private String FML_SELNG_AMT;
    //연령대 10 매출
    private String AGRDE_10_SELNG_AMT;
    //연령대 20 매출
    private String AGRDE_20_SELNG_AMT;
    //연령대 30 매출
    private String AGRDE_30_SELNG_AMT;
    //연령대 40 매출
    private String AGRDE_40_SELNG_AMT;
    //연령대 50 매출
    private String AGRDE_50_SELNG_AMT;
    //연령대 60이상 매출
    private String AGRDE_60_ABOVE_SELNG_AMT;
    //점포수
    private String STOR_CO;

    @QueryProjection
    public SellngQqDto(Long id, String year_value,String STDR_YY_CD,String STDR_QU_CD,String TRDAR_SE_CD,
                       String TRDAR_SE_CD_NM,String TRDAR_CD, String TRDAR_CD_NM,String SVC_INDUTY_CD,
                       String SVC_INDUTY_CD_NM,String THSMON_SELNG_AMT,String THSMON_SELNG_CO,String MDWK_SELNG_AMT,
                       String WKEND_SELNG_AMT,String MON_SELNG_AMT,String TUES_SELNG_AMT,String WED_SELNG_AMT,
                       String THUR_SELNG_AMT,String FRI_SELNG_AMT,String SAT_SELNG_AMT,String SUN_SELNG_AMT,
                       String TMZON_00_06_SELNG_AMT,String TMZON_06_11_SELNG_AMT,String TMZON_11_14_SELNG_AMT,
                       String TMZON_14_17_SELNG_AMT,String TMZON_17_21_SELNG_AMT,String TMZON_21_24_SELNG_AMT,
                       String ML_SELNG_AMT,String FML_SELNG_AMT,String AGRDE_10_SELNG_AMT,String AGRDE_20_SELNG_AMT,
                       String AGRDE_30_SELNG_AMT,String AGRDE_40_SELNG_AMT,String AGRDE_50_SELNG_AMT,
                       String AGRDE_60_ABOVE_SELNG_AMT,String STOR_CO){
            this.id =id;
            this.year_value =year_value;
            this.STDR_YY_CD =STDR_YY_CD;
            this.STDR_QU_CD =STDR_QU_CD;
            this.TRDAR_SE_CD =TRDAR_SE_CD;
            this.TRDAR_SE_CD_NM =TRDAR_SE_CD_NM;
            this.TRDAR_CD =TRDAR_CD;
            this.TRDAR_CD_NM =TRDAR_CD_NM;
            this.SVC_INDUTY_CD =SVC_INDUTY_CD;
            this.SVC_INDUTY_CD_NM =SVC_INDUTY_CD_NM;
            this.THSMON_SELNG_AMT =THSMON_SELNG_AMT;
            this.THSMON_SELNG_CO =THSMON_SELNG_CO;
            this.MDWK_SELNG_AMT =MDWK_SELNG_AMT;
            this.WKEND_SELNG_AMT =WKEND_SELNG_AMT;
            this.MON_SELNG_AMT =MON_SELNG_AMT;
            this.TUES_SELNG_AMT =TUES_SELNG_AMT;
            this.WED_SELNG_AMT =WED_SELNG_AMT;
            this.THUR_SELNG_AMT =THUR_SELNG_AMT;
            this.FRI_SELNG_AMT =FRI_SELNG_AMT;
            this.SAT_SELNG_AMT =SAT_SELNG_AMT;
            this.SUN_SELNG_AMT =SUN_SELNG_AMT;
            this.TMZON_00_06_SELNG_AMT =TMZON_00_06_SELNG_AMT;
            this.TMZON_06_11_SELNG_AMT =TMZON_06_11_SELNG_AMT;
            this.TMZON_11_14_SELNG_AMT =TMZON_11_14_SELNG_AMT;
            this.TMZON_14_17_SELNG_AMT =TMZON_14_17_SELNG_AMT;
            this.TMZON_17_21_SELNG_AMT =TMZON_17_21_SELNG_AMT;
            this.TMZON_21_24_SELNG_AMT =TMZON_21_24_SELNG_AMT;
            this.ML_SELNG_AMT =ML_SELNG_AMT;
            this.FML_SELNG_AMT =FML_SELNG_AMT;
            this.AGRDE_10_SELNG_AMT =AGRDE_10_SELNG_AMT;
            this.AGRDE_20_SELNG_AMT =AGRDE_20_SELNG_AMT;
            this.AGRDE_30_SELNG_AMT =AGRDE_30_SELNG_AMT;
            this.AGRDE_40_SELNG_AMT =AGRDE_40_SELNG_AMT;
            this.AGRDE_50_SELNG_AMT =AGRDE_50_SELNG_AMT;
            this.AGRDE_60_ABOVE_SELNG_AMT =AGRDE_60_ABOVE_SELNG_AMT;
            this.STOR_CO =STOR_CO;
    }
}
