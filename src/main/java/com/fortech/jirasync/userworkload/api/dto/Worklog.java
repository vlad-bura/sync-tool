package com.fortech.jirasync.userworkload.api.dto;

import lombok.Data;

@Data
public class Worklog {
    public String activity_name;
    public int hours;
    public int issue_id;
    public String work_date;
    public String parent_key;
    public int external_hours;
    public String reporter;
    public String external_id;
    public int worklog_id;
    public int billed_hours;
    public String issue_key;
    public String billing_attributes;
    public String work_description;
    public String staff_id;
    public String activity_id;
    public String external_result;
    public String hash_value;
    public IssueDetails issue_details;
    public String billing_key;
    public String username;
    public String external_tstamp;
}
