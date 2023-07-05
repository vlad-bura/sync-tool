package com.fortech.jirasync.pat.allocation.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationRequest {
    public String username;
    public String password;
}

