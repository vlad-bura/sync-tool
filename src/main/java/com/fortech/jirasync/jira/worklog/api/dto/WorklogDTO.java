package com.fortech.jirasync.jira.worklog.api.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Getter
@Setter
@Component
public class WorklogDTO {
  private int startAt;
  private int maxResults;
  private int total;
  private ArrayList<WorklogsDTO> worklogs;
}
