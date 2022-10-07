package com.example.demo.controller;


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

import javax.persistence.StoredProcedureQuery;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Optional;

@Controller
public class ApiExplorer {

    @Autowired
    SellingQqService sellingQqService;

    @Autowired
    AvgDataService avgDataService;

    //https://velog.io/@ttomy/SpringBootJPA-%EA%B3%B5%EA%B3%B5%EB%8D%B0%EC%9D%B4%ED%84%B0-db%EC%A0%80%EC%9E%A5%EA%B3%BC-API%EB%A7%8C%EB%93%A4%EA%B8%B0

    @GetMapping(value = "/first")
    public String apiDataGEt(){

        return "/api/api_chart";
    }

    @PostMapping(value = "/api")
    public String apiDataSet(String year_value) throws Exception {

        sellingQqService.saveItemImg(year_value);

        return "redirect:/apiname";
    }

    @GetMapping(value = {"/apiname", "/apiname/{page}"})
    public String apiName(Model model, SellngSearchDto sellngSearchDto,
                          @PathVariable("page") Optional<Integer> page){

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() :0, 20);
        Page<SellngQq> sellngQqs = sellingQqService.findSellng(sellngSearchDto,pageable);
        //System.out.println(sellngQqs.getSize());
        //Sort sort1 = Sort.by().descending();
        //List<SellngQq> sellngQqs = sellingQqService.findSellng();

        //model.addAttribute("apiModel",sellngQqs);
        model.addAttribute("article", sellngQqs);
        model.addAttribute("searchDto", sellngSearchDto);
        model.addAttribute("maxPage", 10);

        return "/api/api_result";
    }

    @GetMapping(value ="/apipro")
    public void apiName(){
        avgDataService.search();
    }
}
