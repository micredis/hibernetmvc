package com.micredis.hibernatemvc;

import com.micredis.hibernatemvc.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {
    public static final int PAGE_SIZE = 10;

    @Autowired
    BooksDAO dao;

    @GetMapping("/")
    public String index(@RequestParam(value = "from", required = false) Long from,
                        @RequestParam(value = "before", required = false) Long before,
                        Model model) {
        List<Book> books;
        boolean haveBefore = false;
        if (from == null && before == null) {
            books = dao.getFrom(0, PAGE_SIZE);
        } else if (from != null) {
            books = dao.getFrom(from, PAGE_SIZE);
            haveBefore = true;
        } else {
            books = dao.getBefore(before, PAGE_SIZE + 1);
            if (books.size() < PAGE_SIZE) {
                books = dao.getFrom(0, PAGE_SIZE);
            } else if (books.size() > PAGE_SIZE) {
                haveBefore = true;
                books = books.subList(1, books.size());
            }
        }

        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        for (Book book : books) {
            min = Math.min(min, book.getId());
            max = Math.max(max, book.getId());
        }

        if (books.size() == PAGE_SIZE) {
            model.addAttribute("from", max);
        }
        if (haveBefore) {
            model.addAttribute("before", min);
        }
        model.addAttribute("books", books);

        return "index";
    }

    @GetMapping("/create-book")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "createBook";
    }

    @GetMapping("/search")
    public String search(@RequestParam("title") String title,
                         Model model) {
        if (title.trim().isEmpty()) {
            return "redirect:/";
        }
        model.addAttribute("books", dao.search(title));
        model.addAttribute("title", title);
        return "index";
    }

    @GetMapping("/edit-book")
    public String editBook(@RequestParam("id") long id, Model model) {
        model.addAttribute("book", dao.get(id));
        return "editBook";
    }

    @GetMapping("/delete-book")
    public String deleteBook(@RequestParam("id") long id, Model model) {
        dao.delete(id);
        return "redirect:/?from=" + (id - 1);
    }

    @GetMapping("/read-book")
    public String readBook(@RequestParam("id") long id, Model model) {
        Book book = dao.get(id);
        book.setReadAlready(Boolean.TRUE);
        dao.update(book);
        return "redirect:/?from=" + (book.getId() - 1);
    }

    @PostMapping("/save-book")
    public String saveBook(@Valid Book book,
                           BindingResult bindingResult,
                           Model model) {

        if (bindingResult.hasErrors()) {
            if (book.getId() == null) {
                return "createBook";
            } else {
                return "editBook";
            }
        }

        if (book.getId() == null) {
            dao.create(book);
        } else {
            Book oldBook = dao.get(book.getId());
            if (oldBook == null) {
                return "redirect:/";
            }
            if (!book.equals(oldBook)) {
                oldBook.setReadAlready(Boolean.FALSE);
                book.setId(book.getId());
                book.setAuthor(oldBook.getAuthor());
                dao.update(book);
            }
        }
        return "redirect:/?from=" + (book.getId() - 1);
    }
}
