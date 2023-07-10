package com.fortech.jirasync.jira.worklog.api;

import com.fortech.jirasync.jira.worklog.api.dto.WorklogDTO;
import com.fortech.jirasync.jira.worklog.service.WorklogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/jira/issue")
@AllArgsConstructor
public class WorklogController {

  private final WorklogService worklogService;

  @GetMapping("/{issueKey}/worklog")
  public ResponseEntity<WorklogDTO> getWorklog(@PathVariable String issueKey) {
    WorklogDTO issueDetails = worklogService.getWorklog(issueKey);
    return ResponseEntity.ok(issueDetails);
  }

}
