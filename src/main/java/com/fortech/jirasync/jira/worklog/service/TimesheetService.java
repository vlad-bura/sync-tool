package com.fortech.jirasync.jira.worklog.service;

import com.fortech.jirasync.jira.config.JiraConfig;
import com.fortech.jirasync.jira.config.JiraRequestService;
import com.fortech.jirasync.jira.worklog.api.dto.TimesheetRequestDto;
import com.fortech.jirasync.jira.worklog.api.dto.TimesheetResponseDto;
import com.fortech.jirasync.jira.worklog.api.exception.CouldNotCreateJiraTimesheetException;
import com.fortech.jirasync.jira.worklog.api.exception.CouldNotDeleteJiraTimesheetException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TimesheetService {

    private static final String REST_API_2_SEARCH = "rest/tempo-timesheets/3/worklogs/";

    private final JiraConfig jiraConfig;
    private final JiraRequestService jiraRequestService;


    public TimesheetResponseDto createTimesheet(TimesheetRequestDto jiraTimesheetDto) {
        String url = jiraConfig.getUrl() + REST_API_2_SEARCH;
        try {
            ResponseEntity<TimesheetResponseDto> responseEntity =
                    jiraRequestService.performPostRequest(url, jiraTimesheetDto, TimesheetResponseDto.class);
            return responseEntity.getBody();
        } catch (Exception e) {
            throw new CouldNotCreateJiraTimesheetException(e.getMessage());
        }
    }

    public void deleteTimesheet(String worklogId) {
        String url = jiraConfig.getUrl() + REST_API_2_SEARCH + worklogId;
        try {
            jiraRequestService.performDeleteRequest(url);
            log.info("Timesheet deleted successfully with id " + worklogId);
        } catch (Exception e) {
            throw new CouldNotDeleteJiraTimesheetException(e.getMessage());
        }
    }
}
