package com.example;

import com.example.controller.HotelController;

public class Main {
    public static void main(String[] args) {
        HotelController controller = new HotelController();

        // Sækjum hotel úr gagnagrunni
        Hotel hotel = DatabaseConnection.getHotelFromDB(5);

        if (hotel != null) {
            controller.addHotel(hotel);
            System.out.println("Hotel added: " + hotel.getName());

            // Prófum að leita eftir nafni
            var searchResults = controller.searchHotelByName("Hotel Borg");
            System.out.println("Found " + searchResults.size() + " hotel(s) by name 'Hilton'");

            // Prófum að bóka
            Booking booking = new Booking(hotel.getId(), 1, new java.util.Date(), new java.util.Date(), "Jon Jonsson");
            boolean booked = controller.addBooking(hotel.getId(), booking);
            System.out.println("Booking successful: " + booked);
        } else {
            System.out.println("Hotel not found.");
        }
    }
}
