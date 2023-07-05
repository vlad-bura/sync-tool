package com.fortech.jirasync.tempo.userworkload.api;


import com.fortech.jirasync.tempo.userworkload.api.dto.WorkloadResponse;
import org.springframework.web.bind.annotation.GetMapping;

public interface UserWorkloadController {

    @GetMapping
    WorkloadResponse getUserWorkload() throws RuntimeException;

}
