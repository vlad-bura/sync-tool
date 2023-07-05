package com.fortech.jirasync.tempo.userworkload.api.dto;

import lombok.Data;

@Data
public class Worklog {
    private String activity_name;
    private int hours;
    private int issue_id;
    private String work_date;
    private String parent_key;
    private int external_hours;
    private String reporter;
    private String external_id;
    private int worklog_id;
    private int billed_hours;
    private String issue_key;
    private String billing_attributes;
    private String work_description;
    private String staff_id;
    private String activity_id;
    private String external_result;
    private String hash_value;
    private IssueDetails issue_details;
    private String billing_key;
    private String username;
    private String external_tstamp;
}
