package com.fortech.jirasync.jira.worklog.api.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class TimesheetResponseDto {

    private int timeSpentSeconds;
    private String dateStarted;
    private String comment;
    private String self;
    private int id;
    private Author author;
    private Issue issue;
    private ArrayList<Object> worklogAttributes;

    @Data
    public static class Author {
        private String self;
        private String name;
        private String displayName;
        private String avatar;
    }

    @Data
    public static class Issue {
        private String self;
        private int id;
        private int projectId;
        private String key;
        private int remainingEstimateSeconds;
        private IssueType issueType;
        private String summary;
    }

    @Data
    public static class IssueType {
        private String name;
        private String iconUrl;
    }

}
