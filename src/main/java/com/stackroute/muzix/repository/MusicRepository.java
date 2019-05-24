package com.stackroute.muzix.repository;

import com.stackroute.muzix.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface MusicRepository extends JpaRepository<Album, Integer> {
    @Query(value = "select * from music where trackname = ?1", nativeQuery = true)
    public List<Album> getByName(String albumname);
}