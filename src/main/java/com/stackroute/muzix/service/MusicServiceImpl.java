package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Album;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.repository.MusicRepository;
import com.stackroute.muzix.domain.Album;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicServiceImpl implements MusicService {

    MusicRepository musicRepository;

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;

    }

    @Override
    public Album saveAlbum(Album album) throws TrackAlreadyExistsException {
        if (musicRepository.existsById(album.getTrackid())) {
            throw new TrackAlreadyExistsException("Album Already Exists");
        }
        Album savedAlbum = musicRepository.save(album);
        if (savedAlbum == null) {
            throw new TrackAlreadyExistsException("Album Already Exists");
        }
        return savedAlbum;
    }


    @Override
    public List<Album> getAllAlbum() {
        return musicRepository.findAll();
    }

    @Override
    public boolean deleteAlbum(int trackid) throws TrackNotFoundException {
        boolean status = false;
        if (musicRepository.existsById(trackid)) {
            musicRepository.deleteById(trackid);
            status = true;
            return status;
        } else {
            throw new TrackNotFoundException("Track id not found");
        }

    }

    @Override
    public Album updateAlbum(Album album) throws TrackNotFoundException {
        if (musicRepository.existsById(album.getTrackid())) {
            Album updateAlbum = musicRepository.save(album);
        }
        else {
            try {
                throw new TrackNotFoundException("Track id not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
            }
            return album;
        }


    @Override
    public List<Album> getByName(String albumname) throws TrackNotFoundException {
        List<Album> track=musicRepository.getByName(albumname);
        if(track.isEmpty())
        {
            throw new TrackNotFoundException("Track id not found");
        }
        return track;
    }
}
