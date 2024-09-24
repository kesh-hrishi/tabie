package com.hrishi.tabie.user;

import com.hrishi.tabie.tab.TabMapper;
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
        userObj.setUserName(userDto.userName());
        userObj.setEmail(userDto.email());
        userObj.setPassword(userDto.password());
        return userObj;
    }

    public UserResponseDtoWithoutRelations touserResponseDtoWithoutRelations(User user) {
        return new UserResponseDtoWithoutRelations(user.getUserName(), user.getEmail());
    }

    public UserResponseDto toUserResponseDto(User user) {
        return new UserResponseDto(user.getUserName(), user.getEmail(),
                user.getTabSessions().stream()
                        .map(tabSessionMapper::toTabSessionResponseDto)
                        .collect(Collectors.toList()));
    }
}
