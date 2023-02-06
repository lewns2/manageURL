package com.lewns2.backend.model;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "members")
public class Member extends BaseEntity {

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


    // Jpa를 위한 기본 생성자 : 롬복의 @NoArgsConstructor 역할
    public Member() {}

    // 생성자
    @Builder // 빌더 패턴을 위함.
    public Member(String nickname, String email, String password, Role role) {
        this.id = id;
        this.nickname = nickname;
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

    public String getNickName() {
        return nickname;
    }

    public void setNickName(String nickName) {
        this.nickname = nickName;
    }
}
