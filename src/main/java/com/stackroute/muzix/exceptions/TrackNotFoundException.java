package com.stackroute.muzix.exceptions;
import com.stackroute.muzix.domain.Album;


public class TrackNotFoundException extends Throwable {
    private String message;
    public TrackNotFoundException(){}
    public TrackNotFoundException(String message)
    {
        super(message);
        this.message=message;
    }

}
