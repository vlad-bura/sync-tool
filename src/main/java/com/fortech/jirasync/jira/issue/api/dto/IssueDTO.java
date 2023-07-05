package com.fortech.jirasync.jira.issue.api.dto;

import lombok.Data;

@Data
public class IssueDTO {
    private String projectKey;
    private String issueType;
    private String summary;
    private String description;
}
