package com.example.controller;
import com.example.DatabaseConnection;
import com.example.Hotel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;




public class HotelControllerTest {
    
    static Hotel testHotel = new Hotel();

    @BeforeAll
    public static void setUpTest() {
        testHotel = DatabaseConnection.getHotelFromDB(1);
        Assertions.assertNotNull(testHotel, "Hotel not found in DB!");
    }



    @Test 
    public void testGetId(){
        int expected = 1;
        int actual = testHotel.getId();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetRegion() {
        String expected = "Suðurnes";
        String actual = testHotel.getRegion();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetName() {
        String expected = "Blue Lagoon Retreat";
        String actual = testHotel.getName();

        assertEquals(expected, actual);
    }


    
    @Test
    public void testUpdateAvailableRoomsInDB() {
        int newRoomCount = 95;
    
        DatabaseConnection.updateAvailableRooms(testHotel.getId(), newRoomCount);
        
        Hotel updatedHotel = DatabaseConnection.getHotelFromDB(testHotel.getId());
        assertEquals(newRoomCount, updatedHotel.getAvailableRooms());
    }

    @Test
    public void testPrintHotelStuff() {
        System.out.println(testHotel.getId());
        System.out.println(testHotel.getName());
        System.out.println(testHotel.getRegion());
        System.out.println(testHotel.getAddress());
        System.out.println(testHotel.getAvailableRooms());
    }


    /**@Test 
    public void getHotelInfo(int hotelID){
        
        
    }*/
}

