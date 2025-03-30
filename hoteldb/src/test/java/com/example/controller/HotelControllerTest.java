package com.example.controller;
import com.example.Hotel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;



public class HotelControllerTest {
    
    static Hotel testHotel = new Hotel();

    @BeforeAll
    public static void setUpTest() {
        //Stillingar t.d. harðkóða inn upplýsingar fyrir test.
        testHotel.setId(1);
        testHotel.setName("KEA");
        testHotel.setaddress("bleh");
        testHotel.setRatings(5);
        testHotel.setAvailableRooms(110);
    }


    @Test 
    public void testGetId(){
        int expected = 1;
        int actual = testHotel.getId();

        assertEquals(expected, actual);
    }


    /**@Test 
    public void getHotelInfo(int hotelID){
        
        
    }*/
}


