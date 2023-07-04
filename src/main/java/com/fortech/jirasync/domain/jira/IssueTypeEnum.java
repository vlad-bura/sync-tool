package com.fortech.jirasync.domain.jira;

public enum IssueTypeEnum {
    BUG("Bug"),
    STORY("Story"),
    TASK("Task"),
    EPIC("Epic");

    private final String name;

    IssueTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
