package com.fortech.jirasync.pat.allocation.api.dto;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String userName;
    private String userEmail;
    private String fullName;
    private String userRole;
    private String token;
    private boolean isActiveDirectory;
}

