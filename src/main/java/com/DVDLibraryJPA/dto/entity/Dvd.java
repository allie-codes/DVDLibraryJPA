package com.DVDLibraryJPA.dto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dvd")
public class Dvd {
    @Id
    @Column(name = "dvd_id")
    private int dvdId;
    @Column(name = "title")
    private String title;
    private String directorName;
    private String studio;
    @Column(name = "user_rating")
    private double userRating;

    public Dvd() {
    }

    public Dvd(int dvdId, String title, String directorName, String studio, double userRating) {
        this.dvdId = dvdId;
        this.title = title;
        this.directorName = directorName;
        this.studio = studio;
        this.userRating = userRating;
    }

    public int getDvdId() {
        return dvdId;
    }

    public void setDvdId(int dvdId) {
        this.dvdId = dvdId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public double getUserRating() {
        return userRating;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }

    @Override
    public String toString() {
        return "Dvd{" +
                "dvdId=" + dvdId +
                ", title='" + title + '\'' +
                ", directorName='" + directorName + '\'' +
                ", studio='" + studio + '\'' +
                ", userRating=" + userRating +
                '}';
    }
}
