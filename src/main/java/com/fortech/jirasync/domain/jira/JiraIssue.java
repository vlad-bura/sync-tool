package com.fortech.jirasync.domain.jira;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class JiraIssue {

    private Fields fields;

    // Getters and Setters

    @Data
    public static class Fields {

        private Project project;
        private String summary;
        private String description;
        @JsonProperty("issuetype")
        private IssueType issueType;

        // Getters and Setters
    }

    @Data
    public static class Project {
        private String key;

        // Getters and Setters
    }

    @Data
    public static class IssueType {
        private IssueTypeEnum name;

        // Getters and Setters
    }
}
