package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SellngSearchDto {

    private String searchDateType;

    private String searchBy;

    private String searchQuery = "";
}
