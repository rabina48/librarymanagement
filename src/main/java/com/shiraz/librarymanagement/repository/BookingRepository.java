package com.shiraz.librarymanagement.repository;

import com.shiraz.librarymanagement.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    Booking findLastByBookId(Long bookId);

    @Query(value = "SELECT * FROM booking WHERE returned_date is null order by id desc", nativeQuery = true)
    List<Booking> findActiveBookings();

    @Query(value = "SELECT * FROM booking WHERE return_date <= CURRENT_DATE AND returned_date is null order by id desc", nativeQuery = true)
    List<Booking> findDelayedBookings();

    List<Booking> findLastThreeByMemberId(Long memberId);


    Booking findByMemberIdAndBookId(Long memberId, Long bookId);
}
