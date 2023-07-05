package com.fortech.jirasync.tempo.userworkload.api.dto;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class IssueDetails{
    public int remaining_estimate;
    public String type_name;
    public int priority_id;
    public String priority_name;
    public int status_id;
    public String project_key;
    public String status_name;
    public int type_id;
    public String created;
    public String project_name;
    public String project_category;
    public String updated;
    public int component_id;
    public String component_name;
}


