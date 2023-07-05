package com.fortech.jirasync.jira.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fortech.jirasync.jira.issue.api.dto.IssueDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class JiraIssueDTO {

    private Fields fields;

    @Data
    @Builder
    public static class Fields {

        private Project project;
        private String summary;
        private String description;
        @JsonProperty("issuetype")
        private IssueType issueType;

        // Getters and Setters
    }

    @Data
    @AllArgsConstructor
    public static class Project {
        private String key;
    }

    @Data
    @AllArgsConstructor
    public static class IssueType {
        private IssueTypeEnum name;
    }

    public static JiraIssueDTO fromIssueDTO(IssueDTO dto) {
        return new JiraIssueDTO(Fields.builder()
                .project(new Project(dto.getProjectKey()))
                .summary(dto.getSummary())
                .description(dto.getDescription())
                .issueType(new IssueType(dto.getIssueType()))
                .build()
        );
    }
}
