package com.fortech.jirasync.pat.allocation.api.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class JiraPTO{
    public String month;
    public ArrayList<String> days;
}

