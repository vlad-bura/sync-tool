package com.fortech.jirasync.jira.worklog.api;


import com.fortech.jirasync.jira.worklog.api.dto.TimesheetRequestDto;
import com.fortech.jirasync.jira.worklog.api.dto.TimesheetResponseDto;
import com.fortech.jirasync.jira.worklog.service.TimesheetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jira")
@RequiredArgsConstructor
public class TimesheetController {

    private final TimesheetService timesheetService;


    @PostMapping("/timesheet/addWorklog")
    public ResponseEntity<TimesheetResponseDto> createTimesheet(@RequestBody TimesheetRequestDto timesheetRequestDto) {

        TimesheetResponseDto response = timesheetService.createTimesheet(timesheetRequestDto);
        return ResponseEntity.ok(response);
    }
}
