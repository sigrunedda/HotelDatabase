package com.example.controller;
import com.example.*;
import java.util.*;
import java.util.List;
//import com.example.Hotel;

public class HotelController {

    private List<Hotel> hotelList = new ArrayList<Hotel>();

    // Set up initial hotel list.
    public HotelController() {
        // Add all hotels here,
    }

    public List<Hotel> searchHotelByName(String name) {
        List<Hotel> foundHotels = new ArrayList<Hotel>();

        // Loop through all hotels, and add hotels that contain the searched word into a list.
        for (Hotel hotel:hotelList) {
            if (hotel.getName().toLowerCase().contains(name.toLowerCase())) {
                foundHotels.add(hotel);
            }
        }
        return foundHotels;
    }

    public List<Hotel> searchHotelByRegion(String region) {
        List<Hotel> foundHotels = new ArrayList<Hotel>();

        for (Hotel hotel:hotelList) {
            if (hotel.getRegion().toLowerCase().contains(region.toLowerCase())) {
                foundHotels.add(hotel);
            }
        }
        return foundHotels;
    }

    ///  REVIEW: What hotel info? What exactly does it do?
    public Hotel getHotelInfo(int hotelID) {
        
    }

//Bætir við bókun fyrir hótel
    public boolean addBooking(int hotelID, Booking booking) {

    }

//Hættir við bókun fyrir hótel
    public boolean cancelBooking(int bookingID) {

    }

//Uppfærum 
    public boolean updateAmenities(int hotelID, Amenities amenities) {

    }

    public boolean updateAvailableRooms(int hotelID, int rooms){

    }

    public boolean checkRoomAvailability(int hotelID, Date fromDate, Date toDate) {

    }


}