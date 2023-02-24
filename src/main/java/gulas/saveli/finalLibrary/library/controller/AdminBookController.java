package gulas.saveli.finalLibrary.library.controller;

import gulas.saveli.finalLibrary.library.errorHandler.exception.EntityNotFoundException;
import gulas.saveli.finalLibrary.library.errorHandler.exception.NameAlreadyTakenException;
import gulas.saveli.finalLibrary.library.model.Book;
import gulas.saveli.finalLibrary.library.service.BookService;
import gulas.saveli.finalLibrary.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/book")
@RequiredArgsConstructor
public class AdminBookController {

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final BookService bookService;

    @GetMapping("/available")
    public List<Book> getAvailableBooks() {
        return bookService.getAvailableBooks();
    }

    @GetMapping("/unavailable")
    public List<Book> getUnavailableBooks() {
        return bookService.getUnavailableBooks();
    }

    @PostMapping("/register")
    public void registerNewObject(@RequestBody Book book) {
        bookService.save(book);
    }

    @PutMapping("/edit/{bookId}")
    public void editBook(
            @PathVariable Long bookId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long genreId,
            @RequestParam(required = false) List<Long> genreIdList,
            @RequestParam(required = false) Long authorId,
            @RequestParam(required = false) Long publisherId
    ) throws NameAlreadyTakenException {
        bookService.editBook(bookId, name, genreId, genreIdList, authorId, publisherId);
    }

    @DeleteMapping("/delete/{bookId}")
    public void deleteById(@PathVariable("bookId") Long bookId) throws EntityNotFoundException {
        bookService.deleteById(bookId);
    }
}
