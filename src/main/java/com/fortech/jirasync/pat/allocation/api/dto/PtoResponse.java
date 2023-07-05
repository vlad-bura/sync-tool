package com.fortech.jirasync.pat.allocation.api.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class PtoResponse {
    public String name;
    public ArrayList<JiraPTO> jiraPTOs;
}
