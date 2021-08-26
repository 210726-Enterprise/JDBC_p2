package com.revature.ghiblihub.controller;

import com.revature.ghiblihub.models.GhibliFilm;
import com.revature.ghiblihub.service.GhibliFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/films")
public class GhibliFilmController {

    private final GhibliFilmService ghibliFilmService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public GhibliFilmController(GhibliFilmService ghibliFilmService){
        this.ghibliFilmService = ghibliFilmService;
    }

    @GetMapping("/api")
    public @ResponseBody
    List<Object> getfilms() {
        String url = "https://ghibliapi.herokuapp.com/films";
        Object[] films = restTemplate.getForObject(url, Object[].class);
        assert films != null;
        return Arrays.asList(films);
    }

    @GetMapping
    public @ResponseBody
    List<GhibliFilm> getAllFilms(){
        return ghibliFilmService.getAllFilms();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    GhibliFilm findFilmById(@PathVariable String id){
        return ghibliFilmService.getFilmById(Integer.parseInt(id));
    }

    @GetMapping("/title/{title}")
    public @ResponseBody
    GhibliFilm getFilmByTitle(@PathVariable String title){
        return ghibliFilmService.getFilmByTitle(title);
    }

    @PostMapping
    public @ResponseBody
    GhibliFilm createFilm(@RequestBody GhibliFilm film){
        return ghibliFilmService.saveFilm(film);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<HttpStatus> deleteFilm(@PathVariable String id){
        ghibliFilmService.deleteFilm(Integer.parseInt(id));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody
    GhibliFilm updateUser(@RequestBody GhibliFilm film){
        return ghibliFilmService.saveFilm(film);
    }
}
