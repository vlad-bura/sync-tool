package com.fortech.jirasync.jira.worklog.api.exception;

public class CouldNotCreateJiraTimesheetException extends RuntimeException{
    public CouldNotCreateJiraTimesheetException(String message) {
        super(message);
    }
}
