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
        if(ghibliFilmRepository.findById(id).isPresent()) {
            return ghibliFilmRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public GhibliFilm getFilmByTitle(String title){
        if (ghibliFilmRepository.findByTitle(title).isPresent()) {
            return ghibliFilmRepository.findByTitle(title).get();
        } else{
            return null;
        }
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
