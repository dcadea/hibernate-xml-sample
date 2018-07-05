package club.cheapok.hibernate.xml.sample;

import club.cheapok.hibernate.xml.sample.dao.AuthorDao;
import club.cheapok.hibernate.xml.sample.dao.BookDao;
import club.cheapok.hibernate.xml.sample.factory.DaoFactory;
import club.cheapok.hibernate.xml.sample.model.Author;
import club.cheapok.hibernate.xml.sample.model.Book;

import static java.util.Arrays.asList;

public class Main {

    private final static DaoFactory daoFactory = DaoFactory.getInstance();

    public static void main(String[] args) {
        final AuthorDao authorDao = daoFactory.getAuthorDao();
        final BookDao bookDao = daoFactory.getBookDao();

        final Book jorasFirstBook = new Book("Jora's First book");
        final Book jorasSecondBook = new Book("Jora's Second book");
        bookDao.create(jorasFirstBook);
        bookDao.create(jorasSecondBook);

        final Author joraKardan = new Author("Jora", "Kardan");
        joraKardan.getBooks().addAll(asList(jorasFirstBook, jorasSecondBook));
        authorDao.create(joraKardan);


        final Book valerasFirstBook = new Book("Valera's First book");
        final Book valerasSecondBook = new Book("Valera's Second book");
        bookDao.create(valerasFirstBook);
        bookDao.create(valerasSecondBook);

        final Author valeraPartizan = new Author("Valera", "Partizan");
        valeraPartizan.getBooks().addAll(asList(valerasFirstBook, valerasSecondBook));
        authorDao.create(valeraPartizan);

        authorDao.findAll().forEach(System.out::println);

        HibernateUtil.close();
    }

}
