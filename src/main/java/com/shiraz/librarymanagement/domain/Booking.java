package com.shiraz.librarymanagement.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long bookId;

    private Long memberId;

    @CreationTimestamp
    private LocalDate issuedDate;

    private LocalDate returnDate;

    private LocalDate returnedDate;

}
