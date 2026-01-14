package com.enesderin.personal_portfolio_backend.service;

import com.enesderin.personal_portfolio_backend.dto.request.UserRequest;
import com.enesderin.personal_portfolio_backend.dto.response.UserResponse;

public interface UserService {

    UserResponse getUser(Long id);
    UserResponse createUser(UserRequest userRequest);
    UserResponse updateUser(Long id,UserRequest userRequest);


}
