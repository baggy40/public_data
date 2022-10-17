package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class MonGoobulMoveCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String area;
    private Integer amount2021_10;
    private Integer man2021_10;
    private Integer woman2021_10;
    private Integer amount2021_11;
    private Integer man2021_11;
    private Integer woman2021_11;
    private Integer amount2021_12;
    private Integer man2021_12;
    private Integer woman2021_12;
}
