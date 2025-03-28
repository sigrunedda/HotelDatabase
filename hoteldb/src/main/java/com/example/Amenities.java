package com.example;

public class Amenities {
    private Boolean spa;
    private Boolean breakfast;
    private Boolean transport;
    private Boolean gym;
    private Boolean swimmingPool;
    private Boolean daycare;
    private Boolean restaurant;
    private Boolean miniBar;
    private Boolean roomService;
    private Boolean bar;
    private Boolean wifi;
    private Boolean washingMachine;

    public Amenities (Amenities amenities) {
        if (amenities != null) {
            this.spa = amenities.spa;
            this.breakfast = amenities.breakfast;
            this.transport = amenities.transport;
            this.gym = amenities.gym;
            this.swimmingPool = amenities.swimmingPool;
            this.daycare = amenities.daycare;
            this.restaurant = amenities.restaurant;
            this.miniBar = amenities.miniBar;
            this.roomService = amenities.roomService;
            this.bar = amenities.bar;
            this.wifi = amenities.wifi;
            this.washingMachine = amenities.washingMachine;
        } else {
            this.spa = false;
            this.breakfast = false;
            this.transport = false;
            this.gym = false;
            this.swimmingPool = false;
            this.daycare = false;
            this.restaurant = false;
            this.miniBar = false;
            this.roomService = false;
            this.bar = false;
            this.wifi = false;
            this.washingMachine = false;
        }
    }

    public void setProperty(String property, Boolean value) {
        switch (property.toLowerCase()) {
            case "spa":
                this.spa = value;
                break;
            case "breakfast":
                this.breakfast = value;
                break;
            case "transport":
                this.transport = value;
                break;
            case "gym":
                this.gym = value;
                break;
            case "swimmingpool":
                this.swimmingPool = value;
                break;
            case "daycare":
                this.daycare = value;
                break;
            case "restaurant":
                this.restaurant = value;
                break;
            case "minibar":
                this.miniBar = value;
                break;
            case "roomservice":
                this.roomService = value;
                break;
            case "bar":
                this.bar = value;
                break;
            case "wifi":
                this.wifi = value;
                break;
            case "washingmachine":
                this.washingMachine = value;
                break;
            default:
                throw new IllegalArgumentException("Unknown property: " + property);
        }
    }

    public Boolean getProperty(String property) {
        switch (property.toLowerCase()) {
            case "spa":
                return this.spa;
            case "breakfast":
                return this.breakfast;
            case "transport":
                return this.transport;
            case "gym":
                return this.gym;
            case "swimmingpool":
                return this.swimmingPool;
            case "daycare":
                return this.daycare;
            case "restaurant":
                return this.restaurant;
            case "minibar":
                return this.miniBar;
            case "roomservice":
                return this.roomService;
            case "bar":
                return this.bar;
            case "wifi":
                return this.wifi;
            case "washingmachine":
                return this.washingMachine;
            default:
                throw new IllegalArgumentException("Unknown property: " + property);
        }
    }
}