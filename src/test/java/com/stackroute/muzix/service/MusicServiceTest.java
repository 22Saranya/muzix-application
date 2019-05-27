package com.stackroute.muzix.service;

import org.junit.Test;
import static org.junit.Assert.*;
import com.stackroute.muzix.domain.Album;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.repository.MusicRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MusicServiceTest {

    private Album album;

    //Create a mock for UserRepository
    @Mock
    private MusicRepository musicRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private MusicServiceImpl musicService;
    List<Album> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        album = new Album();
        album.setTrackid(101);
        album.setTrackname("Jenny");
        album.setGenre("western");
        list = new ArrayList<>();
        list.add(album);


    }

    @Test
    public void saveAlbumTestSuccess() throws TrackAlreadyExistsException {

        when(musicRepository.save((Album)any())).thenReturn(album);
        Album savedAlbum = musicService.saveAlbum(album);
        Assert.assertEquals(album,savedAlbum);

        //verify here verifies that userRepository save method is only called once
        verify(musicRepository,times(1)).save(album);

    }

    @Test(expected = TrackAlreadyExistsException.class)
    public void saveAlbumTestFailure() throws TrackAlreadyExistsException {
        when(musicRepository.save((Album)any())).thenReturn(null);
        Album savedAlbum = musicService.saveAlbum(album);
        System.out.println("savedAlbum" + savedAlbum);
        Assert.assertEquals(album,savedAlbum);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

    @Test
    public void getAllUser(){

        musicRepository.save(album);
        //stubbing the mock to return specific data
        when(musicRepository.findAll()).thenReturn(list);
        List<Album> userlist = musicService.getAllAlbum();
        Assert.assertEquals(list,userlist);
    }




}