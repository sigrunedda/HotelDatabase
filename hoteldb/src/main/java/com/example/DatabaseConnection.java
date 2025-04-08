package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
    public static void main(String[] args) {
        // Neon connection string
        String url = "jdbc:postgresql://ep-lingering-voice-a55okvue-pooler.us-east-2.aws.neon.tech/hotel?sslmode=require";
        String user = "hotel_owner";
        String password = "npg_nWObTCF4kms9";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Hotel");

            while (rs.next()) {
                System.out.println("Hotel: " + rs.getString("amenities"));
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
