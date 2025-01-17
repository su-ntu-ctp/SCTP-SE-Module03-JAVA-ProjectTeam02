package com.sctp.module3project2.entity;

// import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// Update by Farhan
@Entity
@Table(name = "berth", schema = "public")
public class Berth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Cannot be empty")
    @Size(max = 50, message = "Entry cannot exceed 50 characters")
    @Column(nullable = false, length = 50)
    private String name;

    @NotBlank(message = "Cannot be empty")
    @Size(max = 50, message = "Entry cannot exceed 50 characters")
    @Column(nullable = false, length = 50)
    private String location; // Add the location field

    @Column(name = "is_available", nullable = false)
    private boolean availability;

    // NEW PROPERTIES.
    @OneToOne(mappedBy = "berth")
    private Booking booking;

    // @OneToMany(mappedBy = "berth")
    // private List<Berth> portLocations;

    // @ManyToOne
    // @JoinColumn(name = "berth_id")
    // private Berth berth;

    // CONSTRUCTORS.
    public Berth() {
    }

    public Berth(Long id, String name, String location, boolean availability) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.availability = availability;
    }

    // GETTERS AND SETTERS.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    // OneToOne relationship
    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    // OneToMany relationship
    // public List<PortLocations> getPortLocations() {
    // return portLocations;
    // }

    // public void setPortLocations(List<PortLocations> portLocations) {
    // this.portLocations = portLocations;
    // }

    // ManyToOne relationship
    // public Berth getBerth() {
    // return berth;
    // }

    // public void setBerth(Berth berth) {
    // this.berth = berth;
    // }

}
