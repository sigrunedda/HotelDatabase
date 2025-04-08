package com.example.controller;
import com.example.*;

//import com.example.Hotel;
import java.util.*;

//Controller klasi
public class HotelController {
    private List<Hotel> hotels;

//Smiður
    public HotelController() {
        hotels = new ArrayList<>();
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }
//Leitar af hótelum eftir nafni
    public List<Hotel> searchHotelByName(String name) {
        List<Hotel> result = new ArrayList<>();
        for (Hotel hotel : hotels) {
             if (hotel.getName() != null && hotel.getName().toLowerCase().contains(name.toLowerCase())) {
                  result.add(hotel);
             }
        }
        return result;
    }

//Leitar af hotelum eftir svæði
    public List<Hotel> searchHotelByRegion(String region) {
        List<Hotel> result = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getRegion() != null && hotel.getRegion().equalsIgnoreCase(region)) {
                 result.add(hotel);
            }
        }
        return result;
    }

//Skilar upplýsingum um hótelið
    public Hotel getHotelInfo(int hotelID) {
        for (Hotel hotel : hotels) {
            if (hotel.getId() == hotelID) {
                return hotel;
            }
       }
       return null;
    }

//Bætir við bókun fyrir hótel 
    public boolean addBooking(int hotelID, Booking booking) {
        Hotel hotel = getHotelInfo(hotelID);
        if (hotel != null) {
             return hotel.addBooking(booking);
        }
        return false;
    }

//Hættir við bókun fyrir hótel
    public boolean cancelBooking(int bookingID) {
        for (Hotel hotel : hotels) {
            Booking currentBooking = hotel.getBooking();
            if (currentBooking != null && currentBooking.getBookingId() == bookingID) {
                // Clear the booking. In a multi-booking design, you would remove this booking from a list.
                hotel.addBooking(null);
                return true;
            }
        }
        return false;
    }

//Uppfærum 
    public boolean updateAmenities(int hotelID, Amenities amenities) {
        Hotel hotel = getHotelInfo(hotelID);
        if (hotel != null) {
            hotel.setAmenities(amenities);
            return true;
        }
        return false;
    }

    public boolean updateAvailableRooms(int hotelID, int rooms){
        Hotel hotel = getHotelInfo(hotelID);
        if (hotel != null) {
            hotel.setAvailableRooms(rooms);
            return true;
        }
        return false;
    }

    public boolean checkRoomAvailability(int hotelID, Date fromDate, Date toDate) {
        Hotel hotel = getHotelInfo(hotelID);
        if (hotel != null) {
            return hotel.getAvailableRooms() > 0;
        }
        return false;
    }


}