package com.commonground.entity;

import org.hibernate.annotations.*;
import org.springframework.format.annotation.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.*;
import java.util.*;

@Table(name = "common_ground")
@Entity
public class CommonGround {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="groupId")
    private Group group;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Basic
    private LocalDateTime startDateTime;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Basic
    private LocalDateTime endDateTime;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;

    public void setId(Long id) {
        this.id = id;
    }
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
}