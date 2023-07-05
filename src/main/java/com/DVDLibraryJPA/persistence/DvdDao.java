package com.DVDLibraryJPA.persistence;

import com.DVDLibraryJPA.dto.entity.Dvd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface DvdDao extends JpaRepository<Dvd, Integer> {
    Dvd findByTitle(String title);
    @Transactional
    void deleteByTitle(String title);
}
