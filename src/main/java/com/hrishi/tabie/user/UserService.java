package com.hrishi.tabie.user;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDtoWithoutRelations saveUser(UserDto userDto) {
        var user = userMapper.toUser(userDto);
        var savedUser = userRepository.save(user);
        return userMapper.touserResponseDtoWithoutRelations(savedUser);
    }

    public UserResponseDtoWithoutRelations displayUserByUsername(String username) {
        var savedUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return userMapper.touserResponseDtoWithoutRelations(savedUser);
    }

    public List<UserResponseDto> displayUser() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponseDto)
                .collect(Collectors.toList());
    }

    public UserResponseDto displayUserById(Integer userId) {
        return userRepository.findById(userId)
                .map(userMapper::toUserResponseDto)
                .orElse(null);
    }

    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }
}
