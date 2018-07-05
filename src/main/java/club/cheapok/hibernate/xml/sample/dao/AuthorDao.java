package club.cheapok.hibernate.xml.sample.dao;

import club.cheapok.hibernate.xml.sample.model.Author;

import java.util.List;

public interface AuthorDao {
    List<Author> findAll();

    void create(Author author);
}
