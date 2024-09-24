package com.hrishi.tabie.tabsession;

import com.hrishi.tabie.tab.TabMapper;
import com.hrishi.tabie.tab.TabResponseDto;
import com.hrishi.tabie.user.User;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TabSessionMapper {

    private final TabMapper tabMapper;

    public TabSessionMapper(TabMapper tabMapper) {
        this.tabMapper = tabMapper;
    }

    public TabSession toTabSession(TabSessionDto dto) {
        var tabSessionObj = new TabSession();
        tabSessionObj.setSessionName(dto.sessionName());

        var userObj = new User();
        userObj.setId(dto.userId());

        tabSessionObj.setUser(userObj);

        return tabSessionObj;
    }

    public TabSessionResponseDto toTabSessionResponseDto(TabSession tabSession) {
        return new TabSessionResponseDto(tabSession.getSessionName(),tabSession.getTabs().stream()
                                                                                .map(tabMapper::toTabResponseDto)
                                                                                .collect(Collectors.toList()));
    }

    public TabSessionResponseDtoWithoutTabs toTabSessionResponseDtoWithoutTabs(TabSession tabSession) {
        return new TabSessionResponseDtoWithoutTabs(tabSession.getSessionName());
    }
}
