package com.hrishi.tabie.tabsession;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TabSessionController {

    private final TabSessionService tabSessionService;

    public TabSessionController(TabSessionService tabSessionService) {
        this.tabSessionService = tabSessionService;
    }

    @PostMapping("/tabsessions")
    public TabSessionResponseDto createTabSession(@RequestBody TabSessionDto tabSessiondto) {
        return this.tabSessionService.saveTabSession(tabSessiondto);
    }

    @GetMapping("/tabsessions")
    public List<TabSessionResponseDto> getAllTabSessions() {
        return this.tabSessionService.displayTabSession();
    }

    @GetMapping("/tabsessions/{tabsessions-id}")
    public TabSessionResponseDto getTabSessionById(@PathVariable("tabsessions-id") Integer tabsessionsId) {
        return this.tabSessionService.displayTabSessionById(tabsessionsId);
    }

    @DeleteMapping("/tabsessions/{tabsessions-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTabSession(@PathVariable("tabsessions-id") Integer tabsessionsId) {
        tabSessionService.deleteTabSessionById(tabsessionsId);
    }
}
