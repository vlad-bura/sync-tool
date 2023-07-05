package com.fortech.jirasync.jira.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jira")
@Getter
@Setter
public class JiraConfig {
    private String url;
    private String username;
    private String token;
}

