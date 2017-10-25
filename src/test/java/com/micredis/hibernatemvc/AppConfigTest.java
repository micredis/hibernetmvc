package com.micredis.hibernatemvc;

import com.micredis.hibernatemvc.pojo.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class AppConfigTest {

    @Autowired
    BooksDAO dao;

    @Test
    public void CRUDTest(){
        Book book = new Book(null, "русский", "description", "author", "isbn", 2017, false);
        dao.create(book);

        Book book2 = dao.get(book.getId());
        assertEquals(book, book2);


    }

}