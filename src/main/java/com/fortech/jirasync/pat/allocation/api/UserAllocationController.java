package com.fortech.jirasync.pat.allocation.api;


import com.fortech.jirasync.pat.allocation.api.dto.AuthenticationRequest;
import com.fortech.jirasync.pat.allocation.api.dto.AuthenticationResponse;
import com.fortech.jirasync.pat.allocation.api.dto.PtoResponse;
import org.springframework.web.bind.annotation.GetMapping;

public interface UserAllocationController {

    @GetMapping
    PtoResponse getUserAllocation();

}
