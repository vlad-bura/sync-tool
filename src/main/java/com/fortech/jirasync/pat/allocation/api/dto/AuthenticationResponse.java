package com.fortech.jirasync.pat.allocation.api.dto;

import lombok.Data;

@Data
public class AuthenticationResponse {
    public String userName;
    public String userEmail;
    public String fullName;
    public String userRole;
    public String token;
    public boolean isActiveDirectory;
}

