package com.example;

public class Hotel {
    private int id;
    private String name;
    private String address;
    private String region;
    Booking booking = new Booking();
    Amenities amenities = new Amenities();
    private int availableRooms;
    private int ratings;

    public int getId(){
        return this.id; 
    }

    public String getName(){
        return this.name;
    }

    public String getaddress(){
        return this.address;
    }

    public String getRegion(){
        return this.region;
    }

    public int getAvailableRooms(){
        return this.availableRooms;
    }

    public int getRatings(){
        return this.ratings;
    }

    public int setId(int id){
        this.id = id;
    }

    public String setName(String name){
        this.name = name;
    }

    public String setaddress(String address){
        this.address = address;
    }

    public String setRegion(String region){
        this.region = region;
    }

    public int setAvailableRooms(int availableRooms){
        this.availableRooms = availableRooms;
    }

    public int setRatings(int ratings){
        this.ratings = ratings;
    }

    public void getHotel(){

    }

    public boolean addBooking(booking) {

    }

    public void getBooking() {
        
    }

    public void setBookings() {

    }

    public int updateAvailableRooms() {

    }
}
