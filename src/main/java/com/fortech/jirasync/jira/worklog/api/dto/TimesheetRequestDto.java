package com.fortech.jirasync.jira.worklog.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimesheetRequestDto {

    private int timeSpentSeconds;
    private int billedSeconds;
    private String dateStarted;
    private String comment;
    private Author author;
    private Issue issue;

    @Data
    public static class Author {
        private String name;
    }


    @Data
    public static class Issue {
        private String key;
    }

}
