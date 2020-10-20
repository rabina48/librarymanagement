package com.shiraz.librarymanagement.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Member extends Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "registeredDate")
    @CreationTimestamp
    private LocalDateTime registeredDate;

    @Column(name = "totalBooksBorrowed")
    private int totalBooksBorrowed;
}
