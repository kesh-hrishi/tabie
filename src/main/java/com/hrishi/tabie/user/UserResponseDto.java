package com.hrishi.tabie.user;

import com.hrishi.tabie.tab.TabResponseDto;
import com.hrishi.tabie.tabsession.TabSessionResponseDto;

import java.util.List;

public record UserResponseDto(String userName, String email, List<TabSessionResponseDto> tabSessions) {
}
