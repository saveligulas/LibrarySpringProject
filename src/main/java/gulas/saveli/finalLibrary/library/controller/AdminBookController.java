package gulas.saveli.finalLibrary.library.controller;

import gulas.saveli.finalLibrary.library.model.Book;
import gulas.saveli.finalLibrary.library.service.BookService;
import gulas.saveli.finalLibrary.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/book")
@RequiredArgsConstructor
public class AdminBookController {

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final BookService bookService;

    @PostMapping
    public void registerNewObject(@RequestBody Book book) {
        bookService.save(book);
    }

    @DeleteMapping("{bookId}")
    public void deleteById(@PathVariable("bookId") Long bookId) {
        bookService.deleteById(bookId);
    }
}
