package gulas.saveli.finalLibrary.library.controller;

import gulas.saveli.finalLibrary.library.model.Book;
import gulas.saveli.finalLibrary.library.service.BookService;
import gulas.saveli.finalLibrary.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/book")
public class BookController {
    private final BookService bookService;
    private final BookRepository bookRepository;
    @Autowired
    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public Collection<Book> getAll() {
        return null;
    }

    @GetMapping(path = "{bookId}")
    public Book getById(@PathVariable("bookId") Long bookId) {
        return bookService.getById(bookId);
    }

    @PostMapping
    public void registerNewObject(@RequestBody Book book) {
        bookService.save(book);
    }

    @DeleteMapping("{bookId}")
    public void deleteById(@PathVariable("bookId") Long bookId) {
        bookService.deleteById(bookId);
    }
}
