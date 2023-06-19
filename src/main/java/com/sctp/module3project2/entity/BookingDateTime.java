package com.sctp.module3project2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


@Entity
@Transactional
@Table(name ="booking_datetime")
public class BookingDateTime {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @NotBlank(message="booking date cannot be blank")
  @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
  private String bookdate;
  
  @NotBlank(message="booking time cannot be blanks")
  @JsonFormat(pattern = "HH:mm", shape= Shape.STRING)
  private String booktime;

  public BookingDateTime() {
  }


    public BookingDateTime(Long i, String bookdate, String booktime) {
        this.id = i;
        this.bookdate = bookdate;
        this.booktime = booktime;
    }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBookdate() {
    return bookdate;
  }

  public void setBookdate(String bookdate) {
    this.bookdate = bookdate;
  }

  public String getBooktime() {
    return booktime;
  }

  public void setBooktime(String booktime) {
    this.booktime = booktime;
  }
  
}