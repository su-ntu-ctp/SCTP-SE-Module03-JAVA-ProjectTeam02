package com.sctp.module3project2.Berth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    // CONSTRUCTORS.
    public Berth() {
    }

    public Berth(String name, String location, boolean availability) {
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
}
