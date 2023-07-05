package com.fortech.jirasync.jira.feature.api.exception;

public class CouldNotGetFeatureFromJiraException extends RuntimeException{
    public CouldNotGetFeatureFromJiraException(String message) {
        super(message);
    }
}
