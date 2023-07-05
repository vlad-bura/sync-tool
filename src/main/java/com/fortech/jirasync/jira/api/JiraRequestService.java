package com.fortech.jirasync.jira.api;

import com.fortech.jirasync.configuration.utils.RequestService;
import com.fortech.jirasync.jira.JiraConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class JiraRequestService extends RequestService {
    private final JiraConfig jiraConfig;

    @Autowired
    public JiraRequestService(JiraConfig jiraConfig, RestTemplate restTemplate) {
        super(restTemplate);
        this.jiraConfig = jiraConfig;
    }


    @Override
    protected String getUsername() {
        return jiraConfig.getUsername();
    }

    @Override
    protected String getToken() {
        return jiraConfig.getToken();
    }
}
