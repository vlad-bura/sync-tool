package com.fortech.jirasync.jira.worklog.api.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthorDTO {
  private String self;
  private String name;
  private String key;
  private String emailAddress;
  private AvatarUrlsDTO avatarUrls;
  private String displayName;
  private boolean active;
  private String timeZone;

}
