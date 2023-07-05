package com.fortech.jirasync.tempo.userworkload.api;


import com.fortech.jirasync.tempo.userworkload.api.dto.Root;
import org.springframework.web.bind.annotation.GetMapping;

public interface UserWorkloadController {

    @GetMapping
    Root getUserWorkload() throws RuntimeException;

}
