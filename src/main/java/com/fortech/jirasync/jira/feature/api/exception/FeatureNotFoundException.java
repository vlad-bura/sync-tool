package com.fortech.jirasync.jira.feature.api.exception;

public class FeatureNotFoundException extends RuntimeException{
    public FeatureNotFoundException(String message) {
        super(message);
    }
}
