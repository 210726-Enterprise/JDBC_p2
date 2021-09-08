package com.revature.ghiblihub.controller;

import com.revature.ghiblihub.models.GhibliFilm;
import com.revature.ghiblihub.service.GhibliFilmService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class GhibliFilmController {

    private static final String url = "https://ghibliapi.herokuapp.com/films";

    private final GhibliFilmService ghibliFilmService;

    private final RestTemplate restTemplate;


    @Autowired
    public GhibliFilmController(GhibliFilmService ghibliFilmService, RestTemplate restTemplate){
        this.ghibliFilmService = ghibliFilmService;
        this.restTemplate = restTemplate;
    }
    
    @GetMapping("/films/api")
    public @ResponseBody
    List<GhibliFilm> getAllFilms(){
        return ghibliFilmService.getAllFilms();
    }

    @GetMapping("/films")
    public String filmsPage(){
        return "films";
    }

    @GetMapping("/films/{id}")
    public @ResponseBody
    GhibliFilm findFilmById(@PathVariable String id){
        return ghibliFilmService.getFilmById(Integer.parseInt(id));
    }

    @GetMapping("/films/title/{title}")
    String getFilmByTitle(@PathVariable String title) {
        return "filmDetail";
    }

    @GetMapping("/films/title/{title}/detail")
    public @ResponseBody
    GhibliFilm filmDetailPage(@PathVariable String title) {
        System.out.println("films/title/" + title + "/detail");
        return ghibliFilmService.getFilmByTitle(title);
    }
//    @PostMapping
//    public void postFilmInfo() {
//        GhibliFilm[] arr = restTemplate.getForObject(url, GhibliFilm[].class);
//        assert arr != null;
//        List<GhibliFilm> list = Arrays.asList(arr);
//        list.forEach(film -> System.out.println(film.toString()));
//        list.forEach(film -> ghibliFilmService.saveFilm(film));
//    }

//    @PostMapping
//    public @ResponseBody
//    GhibliFilm createFilm(@RequestBody GhibliFilm film) {
//        return ghibliFilmService.saveFilm(film);
//    }

//    @DeleteMapping("/{id}")
//    public @ResponseBody
//    ResponseEntity<HttpStatus> deleteFilm(@PathVariable String id){
//        ghibliFilmService.deleteFilm(Integer.parseInt(id));
//        return ResponseEntity.ok(HttpStatus.OK);
//    }

//    @PutMapping
//    public @ResponseBody
//    GhibliFilm updateUser(@RequestBody GhibliFilm film){
//        return ghibliFilmService.saveFilm(film);
//    }
}
