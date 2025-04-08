package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {

    private static final String URL = "jdbc:postgresql://ep-lingering-voice-a55okvue-pooler.us-east-2.aws.neon.tech/hotel?sslmode=require";
    private static final String USER = "hotel_owner";
    private static final String PASSWORD = "npg_nWObTCF4kms9";

    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Hotel");

            while (rs.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(rs.getInt("id"));
                hotel.setName(rs.getString("name"));
                hotel.setAddress(rs.getString("address"));
                hotel.setRegion(rs.getString("region"));
                hotel.setAvailableRooms(rs.getInt("availableRooms"));
                hotel.setRatings(rs.getInt("ratings"));

                // Sækja amenities
                hotel.setAmenities(getAmenitiesForHotel(hotel.getId()));
                // hotel.setBookings(...);

                hotels.add(hotel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hotels;
    }

    Amenities getAmenitiesForHotel(int hotelId) {
        Amenities a = new Amenities();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Amenities WHERE hotelId = ?");
            pstmt.setInt(1, hotelId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                a = new Amenities(
                    rs.getBoolean("spa"),
                    rs.getBoolean("breakfast"),
                    rs.getBoolean("transport"),
                    rs.getBoolean("gym"),
                    rs.getBoolean("swimmingPool"),
                    rs.getBoolean("daycare"),
                    rs.getBoolean("restaurant"),
                    rs.getBoolean("miniBar"),
                    rs.getBoolean("roomService"),
                    rs.getBoolean("bar"),
                    rs.getBoolean("wifi"),
                    rs.getBoolean("washingMachine")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public List<Booking> getBookingsForHotel(int hotelId) {
        List<Booking> bookings = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Booking WHERE hotelId = ?");
            pstmt.setInt(1, hotelId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Booking booking = new Booking(
                    rs.getInt("hotelId"),
                    rs.getInt("bookingId"),
                    rs.getDate("fromDate"),
                    rs.getDate("toDate"),
                    rs.getString("guestName")
                );
                bookings.add(booking);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookings;
    }

}
