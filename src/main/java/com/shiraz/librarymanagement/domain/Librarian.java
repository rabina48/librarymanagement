package com.shiraz.librarymanagement.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Librarian extends Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Date dateOfBirth;

    @CreationTimestamp
    private Date employmentDate;
}
