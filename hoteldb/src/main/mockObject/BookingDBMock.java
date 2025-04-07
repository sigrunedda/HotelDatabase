package com.example;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BookingDBMock {
    private Map<Integer, Booking> bookings = new HashMap<>();

    public void saveBooking(Booking booking) {
        bookings.put(booking.getBookingId(), booking);
    }

    public Booking getBooking(int bookingID) {
        return bookings.get(bookingID);
    }

    public void removeBooking(int bookingID) {
        bookings.remove(bookingID);
    }

    public List<Booking> getBookingsByHotel(int hotelID) {
        return bookings.values().stream()
            .filter(b -> b.getHotelId() == hotelID)
            .collect(Collectors.toList());
    }
}
