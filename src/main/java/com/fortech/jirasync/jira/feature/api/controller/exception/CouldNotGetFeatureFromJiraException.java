package com.fortech.jirasync.jira.feature.api.controller.exception;

public class CouldNotGetFeatureFromJiraException extends RuntimeException{
    public CouldNotGetFeatureFromJiraException(String message) {
        super(message);
    }
}
