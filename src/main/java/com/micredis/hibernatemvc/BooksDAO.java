package com.micredis.hibernatemvc;

import com.micredis.hibernatemvc.pojo.Book;

import java.util.List;

public interface BooksDAO {
    void create(Book book);

    void delete(Book book);

    void delete(long id);

    Book get(long id);

    Book get(Book id);

    List<Book> getFrom(long from, int size);

    List<Book> getBefore(long before, int size);

    void update(Book book);

    List<Book> search(String title);
}
