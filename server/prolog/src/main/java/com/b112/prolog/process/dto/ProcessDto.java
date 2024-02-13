package com.b112.prolog.process.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
public class ProcessDto {
    @Id
    private String id;
    private String company;
    private int end_status;
    private String step;
    private String progress;
    private List<String> tag;
    private String start_date;
    private String end_date;
    private List<Template> essay;
    private List<Template> test;
    private List<Template> interview;
    private int jd_id;



}