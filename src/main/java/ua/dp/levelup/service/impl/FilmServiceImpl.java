package ua.dp.levelup.service.impl;

import ua.dp.levelup.core.model.Film;
import ua.dp.levelup.dao.FilmDao;
import ua.dp.levelup.service.FilmService;

import java.util.List;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
public class FilmServiceImpl implements FilmService
{

    private FilmDao filmDao;

    public void setFilmDao(final FilmDao filmDao)
    {
        this.filmDao = filmDao;
    }

    @Override
    public void createFilm(Film film)
    {
        filmDao.createFilm(film);
    }

    @Override
    public Film getFilmById(long filmId)
    {
        return filmDao.getFilmById(filmId);
    }

    @Override
    public void removeFilmById(long filmId)
    {
        filmDao.removeFilmById(filmId);
    }

    @Override
    public List<Film> getAllFilms()
    {
        return filmDao.getAllFilms();
    }
}
