package com.fortech.jirasync.jira.worklog.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class WorklogsDTO {
  private String self;
  private AuthorDTO author;
  private AuthorDTO updateAuthor;
  private String comment;
  private ZonedDateTime created;
  private ZonedDateTime updated;
  private ZonedDateTime started;
  private String timeSpent;
  private int timeSpentSeconds;
  private int id;
}
