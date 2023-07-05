package com.fortech.jirasync.jira.feature.api.controller.api;

import com.fortech.jirasync.jira.api.dto.feature.JiraFeatureDTO;
import com.fortech.jirasync.jira.feature.api.controller.api.dto.FeatureDto;
import com.fortech.jirasync.jira.feature.service.FeatureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/jira/features")
@Slf4j
@RestController
@RequiredArgsConstructor
public class JiraFeatureController {

    private final FeatureService featureService;

    @PostMapping("/getFeature")
    public ResponseEntity<String> getFeature(@RequestBody FeatureDto featureDto) {
        JiraFeatureDTO jiraFeatureDTO = JiraFeatureDTO.fromDto(featureDto);
        String issueDetails = featureService.getFeatures(jiraFeatureDTO);
        return ResponseEntity.ok(issueDetails);
    }
}
