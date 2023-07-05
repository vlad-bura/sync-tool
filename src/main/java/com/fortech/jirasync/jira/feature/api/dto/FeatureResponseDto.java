package com.fortech.jirasync.jira.feature.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeatureResponseDto {

    private String expand;
    private int startAt;
    private int maxResults;
    private int total;
    private ArrayList<Issue> issues;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Issue{
        private String expand;
        private String id;
        private String self;
        private String key;
    }
}
