package com.fortech.jirasync.controller.api;


import com.fortech.jirasync.controller.api.dto.IssueDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IssueController {
    @GetMapping("/{issueKey}")
    ResponseEntity<String> getIssue(@PathVariable String issueKey);

    @PostMapping
    ResponseEntity<String> createIssue(@RequestBody IssueDTO issueDto);
}
