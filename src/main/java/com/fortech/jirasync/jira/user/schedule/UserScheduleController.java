package com.fortech.jirasync.jira.user.schedule;

import com.fortech.jirasync.jira.user.schedule.dto.Schedule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user/schedule")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserScheduleController {

    private final UserScheduleService userScheduleService;

    @GetMapping
    Schedule getUserWorkload(){
        return userScheduleService.getSchedule();
    }

}