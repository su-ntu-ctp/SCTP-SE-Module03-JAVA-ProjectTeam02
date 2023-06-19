package com.sctp.module3project2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sctp.module3project2.entity.Booking;
import com.sctp.module3project2.entity.BookingDateTime;
import com.sctp.module3project2.repository.BookingRepository;
import com.sctp.module3project2.exception.BookingWithDateTimeNotFoundException;

@Service
public class BookingDateTimeServiceImpl implements BookingDateTimeService {

  @Autowired
  private BookingRepository bookingRepository;

  @Override
  public Booking createBookingWithDateTime(Booking bookingData) {
    
    Booking savedBooking = bookingRepository.save(bookingData);
    return savedBooking;
  }

  @Override
  public void deleteBookingWithDateTime(Long id) {
    bookingRepository.deleteById(id);
  }

  @Override
  public List<Booking> getAllBookingsWithDateTime() {
     List<Booking> allBookingsWithDateTime = bookingRepository.findAll();
    return (List<Booking>)allBookingsWithDateTime;
  }

  @Override
  public Booking getBookingWithDateTime(Long id) {
    Optional<Booking> foundBookingWithDateTime = bookingRepository.findById(id);

    if(foundBookingWithDateTime.isPresent()) {
      return foundBookingWithDateTime.get();
    } else {
      throw new BookingWithDateTimeNotFoundException(id);
    }
  }

  @Override
  public Booking updateBookingWithDateTime(Long id, Booking booking) {
    
    Optional<Booking> wrappedBookingWithDateTimeToUpdate = bookingRepository.findById(id);

    if(!wrappedBookingWithDateTimeToUpdate.isPresent()) {
      throw new BookingWithDateTimeNotFoundException(id);
    }

    // Unwrap it
    Booking bookingWithDateTimeToUpdate = wrappedBookingWithDateTimeToUpdate.get();

     bookingWithDateTimeToUpdate.setRemarks(booking.getRemarks());
        bookingWithDateTimeToUpdate.setActivity(booking.getActivity());
        bookingWithDateTimeToUpdate.setBerth(booking.getBerth());

    BookingDateTime datetimeInfo = booking.getBookingDateTime();

    BookingDateTime datetime = new BookingDateTime(); 
    datetime.setBookdate(datetimeInfo.getBookdate());
    datetime.setBooktime(datetimeInfo.getBooktime());

    bookingWithDateTimeToUpdate.getBookingDateTime().setBookdate(datetime.getBookdate());      
    bookingWithDateTimeToUpdate.getBookingDateTime().setBooktime(datetime.getBooktime());

    
    return bookingRepository.save(bookingWithDateTimeToUpdate);
  }
  
}