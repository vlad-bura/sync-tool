package com.fortech.jirasync.jira.api.dto;

public enum IssueTypeEnum {
    BUG("Bug"),
    STORY("Story"),
    TASK("Task"),
    EPIC("Epic");

    private final String name;

    IssueTypeEnum(String name) {
        this.name = name;
    }

}