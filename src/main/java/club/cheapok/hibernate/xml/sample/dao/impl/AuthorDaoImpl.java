package club.cheapok.hibernate.xml.sample.dao.impl;

import club.cheapok.hibernate.xml.sample.HibernateUtil;
import club.cheapok.hibernate.xml.sample.dao.AuthorDao;
import club.cheapok.hibernate.xml.sample.model.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AuthorDaoImpl implements AuthorDao {

    @Override
    public List<Author> findAll() {
        final Session session = HibernateUtil.getSession();

        return session.createCriteria(Author.class).list();
    }

    @Override
    public void create(final Author author) {
        try (final Session session = HibernateUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        }
    }
}
