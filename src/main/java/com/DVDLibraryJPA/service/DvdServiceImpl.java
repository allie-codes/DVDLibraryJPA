package com.DVDLibraryJPA.service;

import com.DVDLibraryJPA.dto.entity.Dvd;
import com.DVDLibraryJPA.persistence.DvdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DvdServiceImpl implements DvdService {

    @Autowired
    private DvdDao dvdDao;

    @Override
    public Dvd insertDvd(Dvd dvd) {
        if (searchDvdByTitle(dvd.getTitle()) == null)
            return dvdDao.save(dvd);
        return null;
    }

    @Override
    public List<Dvd> getAllDvds() {
        return dvdDao.findAll();
    }

    @Override
    public Dvd searchDvdByTitle(String title) {
        Dvd dvd = dvdDao.findByTitle(title);
        return dvd;
    }

    @Override
    public Dvd deleteDvdByTitle(String title) {
        Dvd dvd = searchDvdByTitle(title);
        if (dvd != null)
            dvdDao.deleteByTitle(title);
        return dvd;
    }

    @Override
    public Dvd updateUserRating(String title, double newRating) {
        Dvd dvd = searchDvdByTitle(title);
        if (dvd != null) {
            dvd.setUserRating(newRating);
            dvdDao.save(dvd);
        }

        return dvd;
    }
}
