package com.example;
import java.util.Date;

public class Booking {
    private int hotelId;
    private int bookingId;
    private Date from;
    private Date to;
    private String guestName;

    public Booking (int hotelId, int bookingId, Date from, Date to, String guestName) {
        this.hotelId = hotelId;
        this.bookingId = bookingId;
        this.from = from;
        this.to = to;
        this.guestName = guestName;
    }

    public int getHotelId() {
        return hotelId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }
}
