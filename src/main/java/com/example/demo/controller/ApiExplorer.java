package com.example.demo.controller;


import com.example.demo.entity.SellngQq;
import com.example.demo.repository.SellingQqRepository;
import com.example.demo.service.SellingQqService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping(value = "/apiname")
    public String apiName(Model model){

        List<SellngQq> sellngQqs = sellingQqService.findSellng();

        model.addAttribute("apiModel",sellngQqs);

        return "/api/api_result";
    }
}
