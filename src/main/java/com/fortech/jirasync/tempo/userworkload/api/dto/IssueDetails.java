package com.fortech.jirasync.tempo.userworkload.api.dto;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class IssueDetails{
    private int remaining_estimate;
    private String type_name;
    private int priority_id;
    private String priority_name;
    private int status_id;
    private String project_key;
    private String status_name;
    private int type_id;
    private String created;
    private String project_name;
    private String project_category;
    private String updated;
    private int component_id;
    private String component_name;
}


