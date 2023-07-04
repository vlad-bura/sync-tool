package com.fortech.jirasync.userworkload.api;


import org.springframework.web.bind.annotation.GetMapping;

public interface UserWorkloadController {

    @GetMapping
    String getUserWorkload();

}
