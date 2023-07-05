package com.fortech.jirasync.jira.issue.mapper;

import com.fortech.jirasync.jira.issue.api.dto.IssueDTO;
import com.fortech.jirasync.jira.issue.jira.JiraIssue;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IssueMapper {
    @Mapping(source = "projectKey", target = "fields.project.key")
    @Mapping(source = "summary", target = "fields.summary")
    @Mapping(source = "description", target = "fields.description")
    @Mapping(source = "issueType", target = "fields.issueType.name")
    JiraIssue toJiraIssue(IssueDTO issueDTO);

    @Mapping(source = "fields.project.key", target = "projectKey")
    @Mapping(source = "fields.summary", target = "summary")
    @Mapping(source = "fields.description", target = "description")
    @Mapping(source = "fields.issueType.name", target = "issueType")
    IssueDTO toIssueDto(JiraIssue jiraIssue);
}