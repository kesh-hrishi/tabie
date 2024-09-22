package com.hrishi.tabie.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hrishi.tabie.tabsession.TabSession;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "T_USER")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String userName;

    @Column(unique = true)
    private String email;

    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToMany(
            mappedBy = "user"
    )
    @JsonManagedReference
    private List<TabSession> tabSessions;

    public User() {
    }

    public User(String userName, String email, String password, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public List<TabSession> getTabSessions() {
        return tabSessions;
    }

    public void setTabSessions(List<TabSession> tabSessions) {
        this.tabSessions = tabSessions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPassword() {
        return password;
    }
}
