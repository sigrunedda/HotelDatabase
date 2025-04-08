package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {

    public static Hotel getHotelFromDB(int hotelId) {
        String url = "jdbc:postgresql://ep-lingering-voice-a55okvue-pooler.us-east-2.aws.neon.tech/hotel?sslmode=require";
        String user = "hotel_owner";
        String password = "npg_nWObTCF4kms9";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Hotel WHERE id = " + hotelId + ";");

            if (rs.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(rs.getInt("id"));
                hotel.setName(rs.getString("name"));
                hotel.setAddress(rs.getString("address"));
                hotel.setRegion(rs.getString("region"));
                hotel.setAvailableRooms(rs.getInt("availablerooms"));
                hotel.setRatings(rs.getInt("ratings"));
                // amenities yrði sótt sérstaklega ef það er í annarri töflu
                return hotel;
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
