package com.hrishi.tabie.tabsession;

import com.hrishi.tabie.user.User;
import org.springframework.stereotype.Service;

@Service
public class TabSessionMapper {

    public TabSession toTabSession(TabSessionDto dto) {
        var tabSessionObj = new TabSession();
        tabSessionObj.setSessionName(dto.sessionName());

        var userObj = new User();
        userObj.setId(dto.userId());

        tabSessionObj.setUser(userObj);

        return tabSessionObj;
    }

    public TabSessionResponseDto toTabSessionResponseDto(TabSession tabSession) {
        return new TabSessionResponseDto(tabSession.getSessionName());
    }
}
