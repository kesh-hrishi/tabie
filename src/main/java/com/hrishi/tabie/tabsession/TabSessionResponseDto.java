package com.hrishi.tabie.tabsession;

import com.hrishi.tabie.tab.TabResponseDto;

import java.util.List;

public record TabSessionResponseDto(String sessionName, List<TabResponseDto> tabs) {
}
