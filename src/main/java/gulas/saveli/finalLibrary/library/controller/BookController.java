package gulas.saveli.finalLibrary.library.controller;

import gulas.saveli.library4.Interfaces.LibraryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/book")
public class BookController implements LibraryController<Book> {
    private final BookService bookService;
    private final BookRepository bookRepository;
    @Autowired
    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping
    @Override
    public Collection<Book> getAll() {
        return null;
    }

    @GetMapping(path = "{bookId}")
    @Override
    public Book getById(@PathVariable("bookId") Long bookId) {
        return bookService.getById(bookId);
    }

    @PostMapping
    @Override
    public void registerNewObject(@RequestBody Book book) {
        bookService.save(book);
    }

    @DeleteMapping("{bookId}")
    @Override
    public void deleteById(@PathVariable("bookId") Long bookId) {
        bookService.deleteById(bookId);
    }
}
