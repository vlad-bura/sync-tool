package com.fortech.jirasync.tempo.userworkload.api.dto;

import lombok.Data;

import java.util.ArrayList;
@Data
public class Worklogs{
    private String issueKey;
    private boolean diffOnly;
    private boolean headerOnly;
    private String format;
    private boolean addBillingInfo;
    private String date_to;
    private boolean addIssueDescription;
    private String userName;
    private boolean addIssueDetails;
    private int duration_ms;
    private boolean addWorklogDetails;
    private String projectKey;
    private int number_of_worklogs;
    private boolean addUserDetails;
    private boolean errorsOnly;
    private boolean validOnly;
    private ArrayList<Worklog> worklog;
    private boolean addParentIssue;
    private boolean addIssueSummary;
    private String billingKey;
    private String date_from;
    private boolean addApprovalStatus;
}
