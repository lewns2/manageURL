package com.lewns2.backend.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "board")
public class Board extends BaseEntity {

    @ManyToOne
    private Member member;

    @Column
    private String title;

    @Column
    private String description;

    @CreatedDate
    private LocalDate createdDate;

    @LastModifiedDate
    private LocalDate updateDate;


    // 생성자
    public Board(Member member, String title, String description, LocalDate createdDate, LocalDate updateDate) {
        this.member = member;
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }
}
