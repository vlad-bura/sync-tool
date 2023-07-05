package com.fortech.jirasync.jira.feature.api.controller.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class FeatureDto {

    private List<String> fields;
    private String jql;
    private int maxResults;
    private int startAt;
    private boolean validateQuery;
}
