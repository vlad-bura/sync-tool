package com.fortech.jirasync.jira.user.schedule;

import com.fortech.jirasync.jira.config.JiraConfig;
import com.fortech.jirasync.jira.user.schedule.dto.Schedule;
import com.fortech.jirasync.jira.config.JiraRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserScheduleService {
    private final JiraConfig jiraConfig;
    private final JiraRequestService jiraRequestService;

    public Schedule getSchedule() {
        String url = jiraConfig.getUrl() + "rest/tempo-core/1/user/schedule?user=vlad.bura&from=2023-05-01&to=2023-06-01";
        ResponseEntity<Schedule> responseEntity = jiraRequestService.performGetRequest(url, Schedule.class);
        return responseEntity.getBody();
    }
}
