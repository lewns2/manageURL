package com.lewns2.backend.domain.member;

import com.lewns2.backend.global.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "members")
public class Member extends BaseEntity {

    @Id
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Role role;

    // 생성자
    public Member(Long id, String email, String password, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
