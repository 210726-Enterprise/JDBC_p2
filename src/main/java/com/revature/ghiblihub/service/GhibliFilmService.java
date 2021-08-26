package com.revature.ghiblihub.service;

import com.revature.ghiblihub.models.GhibliFilm;
import com.revature.ghiblihub.repository.GhibliFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GhibliFilmService {
    private final GhibliFilmRepository ghibliFilmRepository;

    @Autowired
    public GhibliFilmService(GhibliFilmRepository ghibliFilmRepository){
        this.ghibliFilmRepository = ghibliFilmRepository;
    }

    public GhibliFilm getFilmById(Integer id){
        return ghibliFilmRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public GhibliFilm getFilmByTitle(String title){
        return ghibliFilmRepository.findByTitle(title).orElseThrow(RuntimeException::new);
    }

    public List<GhibliFilm> getAllFilms(){
        return ghibliFilmRepository.findAll();
    }

    public GhibliFilm saveFilm(GhibliFilm ghibliFilm){
        return ghibliFilmRepository.save(ghibliFilm);
    }

    public void deleteFilm(Integer id){
        ghibliFilmRepository.findById(id).ifPresent(ghibliFilmRepository::delete);
    }
}
