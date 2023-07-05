package com.fortech.jirasync.jira.feature.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class FeatureRequestDto {

    private List<String> fields;
    private String jql;
    private int maxResults;
    private int startAt;
    private boolean validateQuery;
}
