package com.example.demo.service;

import com.example.demo.dto.SellngSearchDto;
import com.example.demo.entity.SellngQq;
import com.example.demo.repository.SellingQqRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SellingQqService {

    private final SellingQqRepository sellingQqRepository;


    public void saveItemImg(String year_value) throws Exception{

        String result = "";

        StringBuilder  urlBuilder = new StringBuilder ("http://openapi.seoul.go.kr:8088");
        urlBuilder.append("/" +  URLEncoder.encode("61595861746261673636687a74456e","UTF-8") ); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
        urlBuilder.append("/" +  URLEncoder.encode("json","UTF-8") );
        urlBuilder.append("/" + URLEncoder.encode("VwsmTrdarSelngQq","UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
        urlBuilder.append("/" + URLEncoder.encode("1","UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
        urlBuilder.append("/" + URLEncoder.encode("100","UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
        urlBuilder.append("/" + URLEncoder.encode(year_value,"UTF-8"));

        URL url = new URL(urlBuilder.toString());
       /* HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type","application/xml");
        System.out.prLongln("Response code: " + conn.getResponseCode());
        BufferedReader rd;*/
        BufferedReader bf;
        bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
        result = bf.readLine();


        /*if(conn.getResponseCode() >= 200 && conn.getResponseCode() <=300){
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        }else{
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line=rd.readLine()) != null){
            sb.append(line);
        }
        rd.close();
        conn.disconnect();*/
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
        JSONObject VwsmTrdar = (JSONObject)jsonObject.get("VwsmTrdarSelngQq");
        Long totalCount = (Long) VwsmTrdar.get("list_total_count");

        JSONObject subResult = (JSONObject) VwsmTrdar.get("RESULT");
        JSONArray infoArr = (JSONArray) VwsmTrdar.get("row");

        for(int i=0; i<infoArr.size(); i++){
            JSONObject tmp = (JSONObject) infoArr.get(i);
            SellngQq infoObj = new SellngQq();
            infoObj.setYear_value_1(year_value);
            infoObj.setSTDR_YY_CD_2((String) tmp.get("STDR_YY_CD"));
            infoObj.setSTDR_QU_CD_3((String)tmp.get("STDR_QU_CD"));
            infoObj.setTRDAR_SE_CD_4((String)tmp.get("TRDAR_SE_CD"));
            infoObj.setTRDAR_SE_CD_NM_5((String)tmp.get("TRDAR_SE_CD_NM"));
            infoObj.setTRDAR_CD_6((String)tmp.get("TRDAR_CD"));
            infoObj.setTRDAR_CD_NM_7((String)tmp.get("TRDAR_CD_NM"));
            infoObj.setSVC_INDUTY_CD_8((String)tmp.get("SVC_INDUTY_CD"));
            infoObj.setSVC_INDUTY_CD_NM_9((String)tmp.get("SVC_INDUTY_CD_NM"));
            infoObj.setTHSMON_SELNG_AMT_10((String)tmp.get("THSMON_SELNG_AMT"));
            //infoObj.setTHSMON_SELNG_AMT(Integer.parseInt(tmp.get("THSMON_SELNG_AMT")==null? String.valueOf(0) :String.valueOf(tmp.get("THSMON_SELNG_AMT"))));
            //infoObj.setTHSMON_SELNG_AMT(Optional.ofNullable(tmp.get("THSMON_SELNG_AMT")).map(Integer::valueOf).orElse(0));
            infoObj.setTHSMON_SELNG_CO_11((String)tmp.get("THSMON_SELNG_CO"));
            infoObj.setMDWK_SELNG_AMT_12((String)tmp.get("MDWK_SELNG_AMT"));
            infoObj.setWKEND_SELNG_AMT_13((String)tmp.get("WKEND_SELNG_AMT"));
            infoObj.setMON_SELNG_AMT_14((String)tmp.get("MON_SELNG_AMT"));
            infoObj.setTUES_SELNG_AMT_15((String)tmp.get("TUES_SELNG_AMT"));
            infoObj.setWED_SELNG_AMT_16((String)tmp.get("WED_SELNG_AMT"));
            infoObj.setTHUR_SELNG_AMT_17((String)tmp.get("THUR_SELNG_AMT"));
            infoObj.setFRI_SELNG_AMT_18((String)tmp.get("FRI_SELNG_AMT"));
            infoObj.setSAT_SELNG_AMT_19((String)tmp.get("SAT_SELNG_AMT"));
            infoObj.setSUN_SELNG_AMT_20((String)tmp.get("SUN_SELNG_AMT"));
            infoObj.setTMZON_00_06_SELNG_AMT_21((String)tmp.get("TMZON_00_06_SELNG_AMT"));
            infoObj.setTMZON_06_11_SELNG_AMT_22((String)tmp.get("TMZON_06_11_SELNG_AMT"));
            infoObj.setTMZON_11_14_SELNG_AMT_23((String)tmp.get("TMZON_11_14_SELNG_AMT"));
            infoObj.setTMZON_14_17_SELNG_AMT_24((String)tmp.get("TMZON_14_17_SELNG_AMT"));
            infoObj.setTMZON_17_21_SELNG_AMT_25((String)tmp.get("TMZON_17_21_SELNG_AMT"));
            infoObj.setTMZON_21_24_SELNG_AMT_26((String)tmp.get("TMZON_21_24_SELNG_AMT"));
            infoObj.setML_SELNG_AMT_27((String)tmp.get("ML_SELNG_AMT"));
            infoObj.setFML_SELNG_AMT_28((String)tmp.get("FML_SELNG_AMT"));
            infoObj.setAGRDE_10_SELNG_AMT_29((String)tmp.get("AGRDE_10_SELNG_AMT"));
            infoObj.setAGRDE_20_SELNG_AMT_30((String)tmp.get("AGRDE_20_SELNG_AMT"));
            infoObj.setAGRDE_30_SELNG_AMT_31((String)tmp.get("AGRDE_30_SELNG_AMT"));
            infoObj.setAGRDE_40_SELNG_AMT_32((String)tmp.get("AGRDE_40_SELNG_AMT"));
            infoObj.setAGRDE_50_SELNG_AMT_33((String)tmp.get("AGRDE_50_SELNG_AMT"));
            infoObj.setAGRDE_60_ABOVE_SELNG_AMT_34((String)tmp.get("AGRDE_60_ABOVE_SELNG_AMT"));
            infoObj.setSTOR_CO_35((String)tmp.get("STOR_CO"));


            sellingQqRepository.save(infoObj);
        }
    }

    @Transactional(readOnly = true)
    public Page<SellngQq> findSellng(SellngSearchDto sellngSearchDto,Pageable pageable){


        return sellingQqRepository.getSellPage(sellngSearchDto, pageable);
        //Page<SellngQq> resutl = sellingQqRepository.findAll(pageable);

        //List<SellngQq> sellngQqs = sellingQqRepository.findAll();

        //return resutl;
    }


}
