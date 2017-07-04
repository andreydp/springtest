package ua.dp.levelup.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import ua.dp.levelup.core.model.Film;
import ua.dp.levelup.dao.FilmDao;

import java.util.List;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
@Transactional
public class FilmDaoImpl implements FilmDao
{

    private HibernateTemplate template;
    private Session session;

    public void setTemplate(HibernateTemplate template)
    {
        this.template = template;
    }

    @Override
    public void createFilm(Film film)
    {
        template.save(film);
    }

    @Override
    public Film getFilmById(long filmId)
    {
        session = template.getSessionFactory().openSession();
        Film film = template.get(Film.class, filmId);
        if (null != film)
        {
            return film;
        } else
            throw new RuntimeException("There is no such order! FilmId: " + filmId);
    }

    @Override
    public void removeFilmById(long filmId)
    {
        session = template.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Film film = template.get(Film.class, filmId);
        if (null != film)
        {
            template.delete(film);
            transaction.commit();
        } else
            throw new RuntimeException("There is no such order! FilmId: " + filmId);
    }

    @Override
    public List<Film> getAllFilms()
    {
        session = template.getSessionFactory().openSession();
        return template.loadAll(Film.class);
    }
}
