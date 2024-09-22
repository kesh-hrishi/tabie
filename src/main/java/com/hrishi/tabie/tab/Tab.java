package com.hrishi.tabie.tab;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hrishi.tabie.tabsession.TabSession;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "T_TABLE")
public class Tab {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String url;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(
            name = "tabsession-id"
    )
    @JsonBackReference
    private TabSession tabsession;

    public Tab() {
    }

    public Tab(String title, String url, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.title = title;
        this.url = url;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TabSession getTabsession() {
        return tabsession;
    }

    public void setTabsession(TabSession tabsession) {
        this.tabsession = tabsession;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
