package com.hrishi.tabie.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public UserResponseDtoWithoutRelations createUser(@RequestBody UserDto userDto) {
        return this.userService.saveUser(userDto);
    }

    @GetMapping("/users")
    public List<UserResponseDto> getAllUsers() {
        return this.userService.displayUser();
    }

    @GetMapping("/users/{users-id}")
    public UserResponseDto getUserById(@PathVariable("users-id") Integer usersId) {
        return this.userService.displayUserById(usersId);
    }

    @DeleteMapping("/users/{users-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUsersById(@PathVariable("users-id") Integer usersId) {
        userService.deleteUserById(usersId);
    }
}
