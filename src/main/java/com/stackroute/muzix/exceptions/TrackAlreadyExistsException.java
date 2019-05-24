package com.stackroute.muzix.exceptions;
import com.stackroute.muzix.domain.Album;

public class TrackAlreadyExistsException extends Throwable {
    private String message;
    public TrackAlreadyExistsException(){}
    public TrackAlreadyExistsException(String message)
    {
        super(message);
        this.message=message;
    }

}
