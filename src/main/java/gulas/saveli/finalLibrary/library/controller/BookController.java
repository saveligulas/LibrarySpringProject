package gulas.saveli.finalLibrary.library.controller;

import gulas.saveli.finalLibrary.library.model.Book;
import gulas.saveli.finalLibrary.library.service.BookService;
import gulas.saveli.finalLibrary.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/api/book")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private final BookService bookService;


    @GetMapping
    public Collection<Book> getAll() {
        return null;
    }

    @GetMapping(path = "{bookId}")
    public Book getById(@PathVariable("bookId") Long bookId) {
        return bookService.getById(bookId);
    }
}
