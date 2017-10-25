package com.micredis.hibernatemvc;

import com.micredis.hibernatemvc.pojo.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Transactional
@Repository
public class BooksHibernateDAO implements BooksDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Book book) {
        getSession().save(book);
    }

    @Override
    public void delete(Book book) {
        getSession().delete(book);
    }

    @Override
    public void delete(long id) {
        getSession().delete(new Book(id));
    }

    @Override
    public Book get(long id) {
        return getSession().find(Book.class, id);
    }

    @Override
    public Book get(Book book) {
        return get(book.getId());
    }

    @Override
    public List<Book> getFrom(long from, int size) {
        return getSession()
                .createQuery("from Book b where b.id > :start")
                .setParameter("start", from)
                .setMaxResults(size)
                .getResultList();
    }

    @Override
    public List<Book> getBefore(long before, int size) {
        LinkedList result = new LinkedList<>(getSession()
                .createQuery("from Book b where b.id < :start order by b.id desc")
                .setParameter("start", before)
                .setMaxResults(size)
                .getResultList());
        Collections.reverse(result);
        return result;
    }

    @Override
    public void update(Book book) {
        getSession().merge(book);
    }

    @Override
    public List<Book> search(String title) {
        return getSession()
                .createQuery("from Book b where b.title like :prefix")
                .setParameter("prefix", title + "%")
                .getResultList();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
