package com.revature.ghiblihub.controller;

import com.revature.ghiblihub.models.GhibliFilm;
import com.revature.ghiblihub.service.GhibliFilmService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
class GhibliFilmControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private GhibliFilmController ghibliFilmController;

    @MockBean
    private GhibliFilmService ghibliFilmService;

    private List<GhibliFilm> filmList;
    private GhibliFilm film;

    @BeforeEach
    void setUp() {
        film = new GhibliFilm();
        film.setFilmId(1);
        film.setTitle("Title");
        film.setRelease_date("2021");
        film.setDescription("This is a description");
        film.setDirector("Director Person");
        film.setRunning_time(100);

        filmList = new ArrayList<>();
        filmList.add(film);
    }


}