package com.fortech.jirasync.jira.feature.api;

import com.fortech.jirasync.jira.feature.api.dto.FeatureRequestDto;
import com.fortech.jirasync.jira.feature.api.dto.FeatureResponseDto;
import com.fortech.jirasync.jira.feature.service.FeatureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/jira")
@Slf4j
@RestController
@RequiredArgsConstructor
public class JiraFeatureController {

    private final FeatureService featureService;

    @PostMapping("/features/search")
    public FeatureResponseDto searchFeaturesFromJira(@RequestBody FeatureRequestDto featureRequestDto) {
        return featureService.searchFeature(featureRequestDto);
    }
}
