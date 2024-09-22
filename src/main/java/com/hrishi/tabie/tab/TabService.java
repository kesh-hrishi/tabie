package com.hrishi.tabie.tab;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TabService {
    private final TabRepository tabRepository;
    private final TabMapper tabMapper;

    public TabService(TabRepository tabRepository, TabMapper tabMapper) {
        this.tabRepository = tabRepository;
        this.tabMapper = tabMapper;
    }

    public TabResponseDto saveTab(TabDto tabDto) {
        var tab = tabMapper.toTab(tabDto);
        var savedTab = tabRepository.save(tab);
        return tabMapper.toTabResponseDto(savedTab);
    }

    public List<TabResponseDto> displayAllTabs() {
        return tabRepository.findAll().stream()
                .map(tabMapper::toTabResponseDto)
                .collect(Collectors.toList());
    }

    public TabResponseDto displayTabById(Integer id) {
        return tabRepository.findById(id).map(tabMapper::toTabResponseDto).orElse(null);
    }

    public void deleteTabById(Integer id) {
        tabRepository.deleteById(id);
    }

}
