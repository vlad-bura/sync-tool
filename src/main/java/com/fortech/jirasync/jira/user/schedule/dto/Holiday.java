package com.fortech.jirasync.jira.user.schedule.dto;

import lombok.Data;

@Data
public class Holiday {
    public String name;
    public String description;
    public int durationSeconds;
}
