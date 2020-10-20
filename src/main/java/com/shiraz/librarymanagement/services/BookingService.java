package com.shiraz.librarymanagement.services;

import com.shiraz.librarymanagement.domain.Book;
import com.shiraz.librarymanagement.domain.Booking;
import com.shiraz.librarymanagement.domain.Member;
import com.shiraz.librarymanagement.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private MemberService memberService;

    //get booking by book id
    public Booking getBookingByBookId(Long bookId){
        return bookingRepository.findLastByBookId(bookId);
    }

    //get all bookings
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    //get all active bookings
    public List<Booking> getActiveBookings(){
        List<Booking> bookingList = bookingRepository.findActiveBookings();
        return bookingList;
    }

    //get all delayed bookings
    public List<Booking> getDelayedBookings(){
        List<Booking> bookingList = bookingRepository.findDelayedBookings();
        return bookingList;
    }

    //get Booking by member
    public List<Booking> getBookingByMember(Long memberId){
        return bookingRepository.findLastThreeByMemberId(memberId);
    }

    //reserve a book
    public Booking reserveBook(Long memberId, Long bookId) throws Exception{
        Book book = bookService.getBookById(bookId);

        if (book == null){
            throw new Exception("Book not found");
        }

        Booking booking = getBookingByBookId(bookId);
        if (booking != null){
            if (booking.getReturnedDate() == null){
                throw new Exception("Book is not available at this moment.");
            }
        }

        Member member = memberService.getMemberById(memberId);
        if (member == null){
            throw new Exception("Please register as a member");
        }

        List<Booking> bookings = getBookingByMember(memberId);
        if (bookings.size() > 2){
            for (Booking booking1 : bookings){
                if (booking1.getReturnedDate() == null){
                    throw new Exception("Please return a book to take another one.");
                }
            }
        }

        Booking booking1 = new Booking();
        booking1.setMemberId(memberId);
        booking1.setBookId(bookId);
        booking1.setIssuedDate(LocalDate.now());
        booking1.setReturnDate(LocalDate.now().plusDays(15));

        return bookingRepository.save(booking1);
    }


    //get Booking by memberId and bookId
    public Booking getBookingByMemberIdAndBookId(Long memberId, Long bookId){
        return bookingRepository.findByMemberIdAndBookId(memberId, bookId);
    }

    //return book
    public Booking returnBook(Long memberId, Long bookId) throws Exception{
        Member member = memberService.getMemberById(memberId);

        if (member == null){
            throw new Exception("No member record found.");
        }

        Book book = bookService.getBookById(bookId);

        if (book == null){
            throw new Exception("Book not found with that id");
        }

        Booking booking = getBookingByMemberIdAndBookId(memberId, bookId);
        if (booking == null){
            throw new Exception("No booking record found.");
        }

        booking.setReturnDate(LocalDate.now());
        return bookingRepository.save(booking);
    }
}
