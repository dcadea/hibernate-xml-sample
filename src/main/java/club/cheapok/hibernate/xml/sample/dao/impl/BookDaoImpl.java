package club.cheapok.hibernate.xml.sample.dao.impl;

import club.cheapok.hibernate.xml.sample.HibernateUtil;
import club.cheapok.hibernate.xml.sample.dao.BookDao;
import club.cheapok.hibernate.xml.sample.model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDaoImpl implements BookDao {

    @Override
    public void create(final Book book) {
        try (final Session session = HibernateUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        }
    }
}
