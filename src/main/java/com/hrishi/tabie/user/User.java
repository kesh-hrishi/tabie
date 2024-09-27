package com.hrishi.tabie.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hrishi.tabie.tabsession.TabSession;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
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

    public User(String userName, String email, String password, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
