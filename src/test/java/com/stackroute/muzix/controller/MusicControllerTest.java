package com.stackroute.muzix.controller;

import java.lang.String;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.muzix.domain.Album;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.service.MusicService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@WebMvcTest
public class MusicControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private Album album;
    @MockBean
    private MusicService musicService;
    @InjectMocks
    private MusicController musicController;

    private List<Album> list =null;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(musicController).build();
        album = new Album();
        album.setTrackid(102);
        album.setTrackname("Believer");
        album.setGenre("action");
        list = new ArrayList();
        list.add(album);
    }

    @Test
    public void saveAlbum() throws TrackAlreadyExistsException, Exception {
        when(musicService.saveAlbum(any())).thenReturn(album);
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/album")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(album)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getAllAlbum() throws Exception {

            when(musicService.getAllAlbum()).thenReturn(list);
            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/album")
                    .contentType(MediaType.APPLICATION_JSON).content(asJsonString(album)))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
        }

    @Test
    public void deleteTrack() throws TrackNotFoundException, Exception, TrackAlreadyExistsException {

    }

    @Test
    public void updateAlbum() throws TrackNotFoundException, Exception {
        when(musicService.updateAlbum(any())).thenReturn(album);
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/album")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(album)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getByName() {
    }
        private static String asJsonString(final Object obj)
        {
            try{
                return new ObjectMapper().writeValueAsString(obj);

            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
        }

