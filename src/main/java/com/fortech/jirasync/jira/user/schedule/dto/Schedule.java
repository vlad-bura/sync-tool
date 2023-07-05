package com.fortech.jirasync.jira.user.schedule.dto;

import lombok.Data;

import java.util.ArrayList;
@Data
public class Schedule {
    public int numberOfWorkingDays;
    public int requiredSeconds;
    public ArrayList<Day> days;
}