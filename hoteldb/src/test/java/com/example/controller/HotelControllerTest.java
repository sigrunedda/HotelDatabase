package com.example.controller;
import com.example.Hotel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.junit.jupiter.api.*;

public class HotelControllerTest {
    
    static Hotel testHotel = new Hotel();
    static HotelController controller;

    @BeforeAll
    public static void setUp() {
        controller = new HotelController();
    }

    
    @Test
    public void testGetHotelInfo() {
        Hotel hotel = controller.getHotelInfo(1);
        assertNotNull(hotel, "Hotel with ID 1 should exist in the database.");
        assertEquals(1, hotel.getId());
    }
        @Test
    public void testUpdateAvailableRooms() {
        boolean updated = controller.updateAvailableRooms(1, 99);
        assertTrue(updated, "Available rooms update should succeed.");

        Hotel hotel = controller.getHotelInfo(1);
        assertEquals(99, hotel.getAvailableRooms());
    }

    @Test
    public void testSearchHotelByName() {
        // Setup list (simulating UI passing hotels list)
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(controller.getHotelInfo(1));

        List<Hotel> results = controller.searchHotelByName("blue");
        assertFalse(results.isEmpty(), "Should find at least one hotel with 'blue' in the name.");
    }

    @Test
    public void testSearchHotelByRegion() {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(controller.getHotelInfo(1));

        List<Hotel> results = controller.searchHotelByRegion("Suðurnes");
        assertFalse(results.isEmpty(), "Should find at least one hotel in region 'Suðurnes'.");
    }

    @Test
    public void testCheckRoomAvailability() {
        boolean available = controller.checkRoomAvailability(1, new Date(), new Date());
        assertTrue(available, "Hotel should have available rooms.");
    }

}

