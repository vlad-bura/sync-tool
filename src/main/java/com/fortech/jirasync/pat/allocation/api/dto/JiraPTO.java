package com.fortech.jirasync.pat.allocation.api.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class JiraPTO{
    private String month;
    private ArrayList<String> days;
}

