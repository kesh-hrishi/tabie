package com.hrishi.tabie.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{users-id}")
    public User getUserById(@PathVariable("users-id") Integer usersId) {
        return userRepository.findById(usersId).orElse(null);
    }

    @DeleteMapping("/users/{users-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUsersById(@PathVariable("users-id") Integer usersId) {
        userRepository.deleteById(usersId);
    }
}
