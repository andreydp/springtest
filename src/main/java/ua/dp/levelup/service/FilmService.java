package ua.dp.levelup.service;

import ua.dp.levelup.core.model.Film;

import java.util.List;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
public interface FilmService
{
    void createFilm(Film film);

    Film getFilmById(long filmId);

    void removeFilmById(long filmId);

    List<Film> getAllFilms();
}
