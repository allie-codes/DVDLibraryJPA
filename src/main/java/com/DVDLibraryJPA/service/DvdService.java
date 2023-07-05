package com.DVDLibraryJPA.service;

import com.DVDLibraryJPA.dto.entity.Dvd;

import java.util.List;

public interface DvdService {

    Dvd insertDvd(Dvd dvd);
    List<Dvd> getAllDvds();
    Dvd searchDvdByTitle(String title);
    Dvd deleteDvdByTitle(String title);
    Dvd updateUserRating(String title, double newRating);
}
