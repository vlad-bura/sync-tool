package com.fortech.jirasync.jira.issue.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fortech.jirasync.tempo.userworkload.api.dto.Worklogs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class JiraIssueDTO {

    private String id;
    private String self;
    private String key;
    private Fields fields;

    public static JiraIssueDTO fromIssueDTO(IssueDTO dto) {
        return JiraIssueDTO.builder()
                .fields(Fields.builder()
                        .project(new Project(dto.getProjectKey()))
                        .summary(dto.getSummary())
                        .description(dto.getDescription())
                        .issueType(new IssueType("3"))
                        .assignee(new Assignee(dto.getAssignee(), dto.getAssignee()))
                        .build()).build();

    }

    @Builder
    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Fields {
        private String summary;
        private String description;
        private Project project;
        private Assignee assignee;
        @JsonProperty(value = "issuetype")
        private IssueType issueType;
        private Worklogs worklog;

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Accessors(chain = true)
    public static class Project {
        private String key;

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Accessors(chain = true)
    public static class Assignee {
        private String name;
        private String key;

        public static Assignee of(String name) {
            return new Assignee(name, name);
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Accessors(chain = true)
    public static class IssueType {
        private static IssueType TYPE_TASK = new IssueType("3");
        private String id;

        public static IssueType getTypeTask() {
            return TYPE_TASK;
        }
    }
}
