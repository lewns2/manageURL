package com.lewns2.backend.model;


import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "urls")
public class Url extends DateEntity{

    @ManyToOne
    Board board;

    @Column
    String address;

    @Column
    String category;

    // 생성자
    @Builder
    public Url(Board board, String address, String category) {
        this.board = board;
        this.address = address;
        this.category = category;
    }

    // getter and setter
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
