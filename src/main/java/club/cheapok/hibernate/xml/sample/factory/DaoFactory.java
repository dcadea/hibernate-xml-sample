package club.cheapok.hibernate.xml.sample.factory;

import club.cheapok.hibernate.xml.sample.dao.AuthorDao;
import club.cheapok.hibernate.xml.sample.dao.BookDao;
import club.cheapok.hibernate.xml.sample.dao.impl.AuthorDaoImpl;
import club.cheapok.hibernate.xml.sample.dao.impl.BookDaoImpl;

public class DaoFactory {

    private static DaoFactory daoFactory;
    private AuthorDao authorDao;
    private BookDao bookDao;

    private DaoFactory() {
    }

    public static synchronized DaoFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }

        return daoFactory;
    }

    public AuthorDao getAuthorDao() {
        if (authorDao == null) {
            authorDao = new AuthorDaoImpl();
        }

        return authorDao;
    }

    public BookDao getBookDao() {
        if (bookDao == null) {
            bookDao = new BookDaoImpl();
        }
        return bookDao;
    }
}
