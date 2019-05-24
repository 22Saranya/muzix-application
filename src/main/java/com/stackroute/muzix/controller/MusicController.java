package com.stackroute.muzix.controller;

import com.stackroute.muzix.domain.Album;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.service.MusicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")

public class MusicController {
    MusicService musicService;

    public MusicController(MusicService musicService){
        this.musicService = musicService;
    }

    @PostMapping("/album")
    public ResponseEntity<?> saveAlbum (@RequestBody Album album) throws Exception{
        ResponseEntity responseEntity;
        try{
            musicService.saveAlbum(album);
            responseEntity=new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        } catch (TrackAlreadyExistsException e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/album")
    public  ResponseEntity<?> getAllAlbum(){

        return new ResponseEntity<List<Album>>(musicService.getAllAlbum(),HttpStatus.OK);
    }

    @DeleteMapping("/album/{trackid}")
    public ResponseEntity<?> deleteTrack(@PathVariable("trackid") int trackid) throws TrackNotFoundException
    {
        ResponseEntity responseEntity;
        try {
            try {
                musicService.deleteAlbum(trackid);
            } catch (TrackAlreadyExistsException e) {
                e.printStackTrace();
            }
            responseEntity = new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
        }
        catch(TrackNotFoundException exception){
            responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("/album")
    public ResponseEntity<?> updateAlbum (@RequestBody Album album) throws TrackNotFoundException{
            ResponseEntity responseEntity;
            musicService.updateAlbum(album);
            responseEntity=new ResponseEntity<String>("successfully Updated", HttpStatus.CREATED);
        return responseEntity;
    }
    @GetMapping("/trackName/{trackName}")
    public ResponseEntity<List<Album>> getByName (@PathVariable String albumname) throws TrackNotFoundException{
        ResponseEntity responseEntity;
        try {

            return new ResponseEntity<List<Album>>( musicService.getByName(albumname) , HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}



