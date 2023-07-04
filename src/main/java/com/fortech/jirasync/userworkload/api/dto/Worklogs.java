package com.fortech.jirasync.userworkload.api.dto;

import lombok.Data;

import java.util.ArrayList;
@Data
public class Worklogs{
    public String issueKey;
    public boolean diffOnly;
    public boolean headerOnly;
    public String format;
    public boolean addBillingInfo;
    public String date_to;
    public boolean addIssueDescription;
    public String userName;
    public boolean addIssueDetails;
    public int duration_ms;
    public boolean addWorklogDetails;
    public String projectKey;
    public int number_of_worklogs;
    public boolean addUserDetails;
    public boolean errorsOnly;
    public boolean validOnly;
    public ArrayList<Worklog> worklog;
    public boolean addParentIssue;
    public boolean addIssueSummary;
    public String billingKey;
    public String date_from;
    public boolean addApprovalStatus;
}
