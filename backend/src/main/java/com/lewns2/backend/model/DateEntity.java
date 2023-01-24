package com.lewns2.backend.model;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;

@MappedSuperclass
public class DateEntity extends BaseEntity {
    @CreatedDate
    private LocalDate createdDate;

    @LastModifiedDate
    private LocalDate updateDate;

    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDate.now();
        this.updateDate = this.createdDate;
    }

    @PreUpdate
    public void preUpdate() {
        this.updateDate = LocalDate.now();
    }
}
