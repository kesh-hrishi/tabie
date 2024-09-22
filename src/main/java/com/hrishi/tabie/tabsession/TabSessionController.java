package com.hrishi.tabie.tabsession;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TabSessionController {


    private final TabSessionRepository tabSessionRepository;

    public TabSessionController(TabSessionRepository tabSessionRepository) {
        this.tabSessionRepository = tabSessionRepository;
    }

    @PostMapping("/tabsessions")
    public TabSession createUser(@RequestBody TabSession tabSession) {
        return tabSessionRepository.save(tabSession);
    }

    @GetMapping("/tabsessions")
    public List<TabSession> getAllUsers() {
        return tabSessionRepository.findAll();
    }

    @GetMapping("/tabsessions/{tabsessions-id}")
    public TabSession getUserById(@PathVariable("tabsessions-id") Integer tabsessionId) {
        return tabSessionRepository.findById(tabsessionId).orElse(null);
    }

    @DeleteMapping("/tabsessions/{tabsessions-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUsersById(@PathVariable("tabsessions-id") Integer tabsessionsId) {
        tabSessionRepository.deleteById(tabsessionsId);
    }
}
