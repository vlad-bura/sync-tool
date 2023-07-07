package com.fortech.jirasync.jira.worklog.api.exception;

public class CouldNotDeleteJiraTimesheetException extends RuntimeException{
    public CouldNotDeleteJiraTimesheetException(String message) {
        super(message);
    }
}
