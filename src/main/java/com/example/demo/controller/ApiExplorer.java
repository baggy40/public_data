package com.example.demo.controller;


import com.example.demo.dto.Avg_dataDto;
import com.example.demo.dto.SellngSearchDto;
import com.example.demo.entity.Avg_data;
import com.example.demo.entity.SellngQq;
import com.example.demo.repository.SellingQqRepository;
import com.example.demo.service.AvgDataService;
import com.example.demo.service.SellingQqService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class ApiExplorer {

    @Autowired
    SellingQqService sellingQqService;

    @Autowired
    AvgDataService avgDataService;

    //https://velog.io/@ttomy/SpringBootJPA-%EA%B3%B5%EA%B3%B5%EB%8D%B0%EC%9D%B4%ED%84%B0-db%EC%A0%80%EC%9E%A5%EA%B3%BC-API%EB%A7%8C%EB%93%A4%EA%B8%B0

    @GetMapping(value = "/")
    public String apiSearch(){
        return "/api/api_search";
    }

    @GetMapping(value = "/first")
    public String apiDataGEt(){

        return "/api/api_chart";
    }

    @PostMapping(value = "/api")
    public String apiDataSet(String year_value, RedirectAttributes rttr) throws Exception {

        sellingQqService.saveItemImg(year_value);

        rttr.addAttribute("yearData",year_value);

        return "redirect:/apiname";
    }

    @GetMapping(value = {"/apiname", "/apiname/{page}"})
    public String apiName(Model model, SellngSearchDto sellngSearchDto, @RequestParam(value="yearData",defaultValue = "2021") String yearData,
                          @PathVariable("page") Optional<Integer> page){

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() :0, 20);
        Page<SellngQq> sellngQqs = sellingQqService.findSellng(sellngSearchDto,pageable);

       /* Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        Avg_dataDto avgDto = (Avg_dataDto)inputFlashMap.get("avgDto");*/
        //프로시저 호출
        //Avg_dataDto avg_data = avgDataService.search(yearData);

        List<Avg_data> avg_data = avgDataService.search(yearData);
        model.addAttribute("avgDto", avg_data);

        //System.out.println(sellngQqs.getSize());
        //Sort sort1 = Sort.by().descending();
        //List<SellngQq> sellngQqs = sellingQqService.findSellng();

        model.addAttribute("article", sellngQqs);
        model.addAttribute("searchDto", sellngSearchDto);
        model.addAttribute("maxPage", 10);

        return "/api/api_result";
    }

    @PostMapping(value = {"/apiSearch", "/apiSearch/{page}"})
    public String apiSearch(Model model, String year_value, String gubun_value,
                            String store_value, String item_value1, String item_value2){

        System.out.println("======================="+year_value);
        System.out.println("======================="+gubun_value);
        System.out.println("======================="+store_value);
        System.out.println("======================="+item_value1);
        System.out.println("======================="+item_value2);

        return "/api";
    }

}
