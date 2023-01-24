package com.lewns2.backend.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;


@Entity
@Table(name = "board")
public class Board extends DateEntity {

    @ManyToOne
    private Member member;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @OneToMany
    @JoinColumn
    private Set<Url> urls;

    // 생성자
    public Board(Member member, String title, String description) {
        this.member = member;
        this.title = title;
        this.description = description;
    }

    // getter and setter
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // urls 추가
    protected Set<Url> getUrlsInternal() {
        if (this.urls == null) {
            this.urls = new HashSet<>();
        }
        return this.urls;
    }

    public List<Url> getUrls() {
        List<Url> sortedUrls = new ArrayList<>(getUrlsInternal());
        return Collections.unmodifiableList(sortedUrls);
    }

    protected void setUrlsInternal() {
        this.urls = urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = new HashSet<>(urls);
    }
}
