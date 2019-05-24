package com.stackroute.muzix.domain;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    @Id
    int trackid;
    String trackname;
    //String trackcomment;
    String genre;

//    public String getTrackcomment() {
//        return trackcomment;
//    }
//
//    public void setTrackcomment(String trackcomment) {
//        this.trackcomment = trackcomment;
//    }

//    public Album() {
//    }
//
//
//
//    public Album(int trackid, String trackname, String genre) {
//        this.trackid = trackid;
//        this.trackname = trackname;
//        this.genre = genre;
//    }
//
//
//
//    public  int getTrackid() {
//        return trackid;
//    }
//
//    public void setTrackid(int trackid) {
//        this.trackid = trackid;
//    }
//
//    public String getTrackname() {
//        return trackname;
//    }
//
//    public void setTrackname(String trackname) {
//        this.trackname = trackname;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }
//
//    @Override
//    public String toString() {
//        return "Album{" +
//                "trackid=" + trackid +
//                ", trackname='" + trackname + '\'' +
//                ", trackcomment='"  +
//                ", genre='" + genre + '\'' +
//                '}';
//    }
}