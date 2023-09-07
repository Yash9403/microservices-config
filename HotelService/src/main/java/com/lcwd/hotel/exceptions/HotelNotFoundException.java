package com.lcwd.hotel.exceptions;

public class HotelNotFoundException extends RuntimeException{

    public HotelNotFoundException(String msg)
    {
        super(msg);
    }
}
