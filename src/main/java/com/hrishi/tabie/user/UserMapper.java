package com.hrishi.tabie.user;

import com.hrishi.tabie.tabsession.TabSessionMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserMapper {

    private final TabSessionMapper tabSessionMapper;

    public UserMapper(TabSessionMapper tabSessionMapper) {
        this.tabSessionMapper = tabSessionMapper;
    }

    public User toUser(UserDto userDto) {
        var userObj = new User();
        userObj.setUsername(userDto.userName());
        userObj.setEmail(userDto.email());
        userObj.setPassword(userDto.password());
        return userObj;
    }

    public UserResponseDtoWithoutRelations touserResponseDtoWithoutRelations(User user) {
        return new UserResponseDtoWithoutRelations(user.getUsername(), user.getEmail());
    }

    public UserResponseDto toUserResponseDto(User user) {
        return new UserResponseDto(user.getUsername(), user.getEmail(),
                user.getTabSessions().stream()
                        .map(tabSessionMapper::toTabSessionResponseDto)
                        .collect(Collectors.toList()));
    }
}
