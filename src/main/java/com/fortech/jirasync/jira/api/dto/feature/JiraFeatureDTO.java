package com.fortech.jirasync.jira.api.dto.feature;

import com.fortech.jirasync.jira.feature.api.dto.FeatureDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class JiraFeatureDTO {

    //"summary","status","assignee",  implicit: all
    private List<String> fields;
    private String jql;
    private int maxResults;
    private int startAt;
    private boolean validateQuery;

    public static JiraFeatureDTO fromDto(FeatureDto dto){
        return JiraFeatureDTO.builder()
                .fields(dto.getFields())
                .jql(dto.getJql())
                .maxResults(dto.getMaxResults())
                .startAt(dto.getStartAt())
                .validateQuery(dto.isValidateQuery())
                .build();
    }
}