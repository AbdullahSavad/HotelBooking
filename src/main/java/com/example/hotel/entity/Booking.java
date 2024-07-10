package com.example.hotel.entity;

import javax.persistence.*;
import java.time.LocalDate;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity 
@Table(name="booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate dateBooked;
    private LocalDate dateCheckin;
    private LocalDate dateCheckout;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(LocalDate dateBooked) {
        this.dateBooked = dateBooked;
    }

    public LocalDate getDateCheckin() {
        return dateCheckin;
    }

    public void setDateCheckin(LocalDate dateCheckin) {
        this.dateCheckin = dateCheckin;
    }

    public LocalDate getDateCheckout() {
        return dateCheckout;
    }

    public void setDateCheckout(LocalDate dateCheckout) {
        this.dateCheckout = dateCheckout;
    }
}
