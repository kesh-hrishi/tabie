package com.hrishi.tabie.tab;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TabController {

    private final TabService tabService;

    public TabController(TabService tabService) {
        this.tabService = tabService;
    }

    @PostMapping("/tabs")
    public TabResponseDto createTab(@RequestBody TabDto tabDto) {
        return this.tabService.saveTab(tabDto);
    }

    @GetMapping("/tabs")
    public List<TabResponseDto> getAllTabs() {
        return tabService.displayAllTabs();
    }

    @GetMapping("/tabs/{tabs-id}")
    public TabResponseDto getTabById(@PathVariable("tabs-id") Integer tabId) {
        return tabService.displayTabById(tabId);
    }

    @DeleteMapping("/tabs/{tabs-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTabById(@PathVariable("tabs-id") Integer tabId) {
        tabService.deleteTabById(tabId);
    }
}
