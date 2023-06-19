package com.sctp.module3project2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sctp.module3project2.services.BookingDateTimeService;
import com.sctp.module3project2.entity.Booking;


@RequestMapping("api/booking/datetime")

@RestController
public class BookingDateTimeController {

  @Autowired
  private BookingDateTimeService dateTimeService;


  @PostMapping("/create")
  public ResponseEntity<Booking> saveBooking(@Valid @RequestBody Booking bookingData) {
   
    Booking newBooking = dateTimeService.createBookingWithDateTime(bookingData);
    return new ResponseEntity<Booking>(newBooking, HttpStatus.CREATED);

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteBookingWithDateTime(@PathVariable Long id) {
    dateTimeService.deleteBookingWithDateTime(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

   @GetMapping("")
  public ResponseEntity<List<Booking>> getAllBookingsWithDateTime() {

    List<Booking> allBookingsWithDateTime = dateTimeService.getAllBookingsWithDateTime();
    return new ResponseEntity<>(allBookingsWithDateTime, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Booking> getBookingWithDateTime(@PathVariable Long id) {
    Booking foundBookingWithDateTime = dateTimeService.getBookingWithDateTime(id);
    return new ResponseEntity<>(foundBookingWithDateTime, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Booking> updateBookingWithDateTime(@Valid @PathVariable Long id, @RequestBody Booking bookingData) {
    Booking updatedBookingWithDateTime = dateTimeService.updateBookingWithDateTime(id, bookingData);
    return new ResponseEntity<>(updatedBookingWithDateTime, HttpStatus.OK);

  }
}

