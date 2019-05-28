package com.stackroute.muzix.repository;

import org.junit.Test;
import static org.junit.Assert.*;
import com.stackroute.muzix.domain.Album;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
//@DataJpaTest
//@SpringBootTest
@DataMongoTest
public class MusicRepositoryTest {

    @Autowired
    private MusicRepository musicRepository;
    private Album album;

    @Before
    public void setUp()
    {
        album = new Album();
        album.setTrackid(101);
        album.setTrackname("piraithedum");
        album.setGenre("melody");

    }

    @After
    public void tearDown(){

        musicRepository.deleteAll();
    }


    @Test
    public void testSaveUser(){
        musicRepository.save(album);
        Album fetchAlbum = musicRepository.findById(album.getTrackid()).get();
        Assert.assertEquals(101,fetchAlbum.getTrackid());

    }

    @Test
    public void testSaveUserFailure(){
        Album testAlbum = new Album(104,"piraithedum","melody");
        musicRepository.save(album);
        Album fetchAlbum = musicRepository.findById(album.getTrackid()).get();
        Assert.assertNotSame(testAlbum,album);
    }

    @Test
    public void testGetAllUser(){
        Album album1 = new Album(104,"piraithedum","melody");
        Album album2 = new Album(106,"neeyum","rock");
        musicRepository.save(album1);
        musicRepository.save(album2);
        List<Album> list = musicRepository.findAll();
       Assert.assertEquals("orasadha",list.get(0).getTrackname());

    }

}