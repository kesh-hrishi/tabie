package com.hrishi.tabie.tab;

import com.hrishi.tabie.tabsession.TabSession;
import org.springframework.stereotype.Service;

@Service
public class TabMapper {

    public Tab toTab(TabDto dto) {
        var tabObj = new Tab();
        tabObj.setTitle(dto.title());
        tabObj.setUrl(dto.url());

        var tabsessionObj = new TabSession();
        tabsessionObj.setId(dto.tabsessionId());

        tabObj.setTabsession(tabsessionObj);

        return tabObj;
    }

    public TabResponseDto toTabResponseDto(Tab tab) {
        return new TabResponseDto(tab.getTitle(), tab.getUrl());
    }
}
