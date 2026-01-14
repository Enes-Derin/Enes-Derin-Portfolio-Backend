package com.enesderin.personal_portfolio_backend.controller;

import com.enesderin.personal_portfolio_backend.dto.request.UserRequest;
import com.enesderin.personal_portfolio_backend.dto.response.UserResponse;

public interface UserController {

    RootEntity<UserResponse> getUser(Long id);
    RootEntity<UserResponse> createUser(UserRequest userRequest);
    RootEntity<UserResponse> updateUser(Long id,UserRequest userRequest);

}
