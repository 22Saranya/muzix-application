package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Album;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;

import java.util.List;

public interface MusicService {
    public Album saveAlbum(Album album) throws TrackAlreadyExistsException;
    public List<Album> getAllAlbum();
    public boolean deleteAlbum(int trackid) throws TrackAlreadyExistsException, TrackNotFoundException;
    public Album updateAlbum(Album album) throws TrackNotFoundException;

    List<Album> getByName(String Album) throws TrackNotFoundException;
}
