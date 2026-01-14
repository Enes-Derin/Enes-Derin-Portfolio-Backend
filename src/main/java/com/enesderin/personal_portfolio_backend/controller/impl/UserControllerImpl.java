package com.enesderin.personal_portfolio_backend.controller.impl;

import com.enesderin.personal_portfolio_backend.controller.RestBaseController;
import com.enesderin.personal_portfolio_backend.controller.RootEntity;
import com.enesderin.personal_portfolio_backend.controller.UserController;
import com.enesderin.personal_portfolio_backend.dto.request.UserRequest;
import com.enesderin.personal_portfolio_backend.dto.response.UserResponse;
import com.enesderin.personal_portfolio_backend.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserControllerImpl extends RestBaseController implements UserController {

    private UserService userService;

    @GetMapping("/{id}")
    @Override
    public RootEntity<UserResponse> getUser(@PathVariable Long id) {
        return ok(userService.getUser(id));
    }

    @PostMapping
    @Override
    public RootEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
        return ok(userService.createUser(userRequest));
    }

    @PutMapping("/{id}")
    @Override
    public RootEntity<UserResponse> updateUser(@PathVariable Long id,@Valid @RequestBody UserRequest userRequest) {
        return ok(userService.updateUser(id, userRequest));
    }
}
