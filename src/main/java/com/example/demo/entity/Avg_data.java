package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;
@Entity
@Data
@NamedStoredProcedureQuery(
        name = "cal_pro_out2",
        procedureName = "cal_pro_out2",
        resultClasses = { Avg_data.class },
        parameters = {
                @StoredProcedureParameter(name = "RESULT", type = Integer.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "tues", type = Integer.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "fris", type = Integer.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "mons", type = Integer.class, mode = ParameterMode.OUT),
        })
public class Avg_data{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int RESULT;
    private int tues;
    private int fris;
    private int mons;

}
