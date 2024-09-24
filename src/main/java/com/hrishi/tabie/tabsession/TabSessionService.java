package com.hrishi.tabie.tabsession;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TabSessionService {

    private final TabSessionRepository tabSessionRepository;
    private final TabSessionMapper tabSessionMapper;

    public TabSessionService(TabSessionRepository tabSessionRepository, TabSessionMapper tabSessionMapper) {
        this.tabSessionRepository = tabSessionRepository;
        this.tabSessionMapper = tabSessionMapper;
    }

    public TabSessionResponseDtoWithoutTabs saveTabSession(TabSessionDto tabSessionDto) {
        var tabSession = tabSessionMapper.toTabSession(tabSessionDto);
        var savedTabSession = tabSessionRepository.save(tabSession);
        return tabSessionMapper.toTabSessionResponseDtoWithoutTabs(savedTabSession);
    }

    public List<TabSessionResponseDto> displayTabSession() {
        return tabSessionRepository.findAll().stream()
                .map(tabSessionMapper::toTabSessionResponseDto)
                .collect(Collectors.toList());
    }

    public TabSessionResponseDto displayTabSessionById(Integer tabSessionId) {
        return tabSessionRepository.findById(tabSessionId).
                map(tabSessionMapper::toTabSessionResponseDto)
                .orElse(null);

    }

    public void deleteTabSessionById(Integer tabSessionId) {
        tabSessionRepository.deleteById(tabSessionId);
    }
}
