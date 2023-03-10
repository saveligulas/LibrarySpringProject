package gulas.saveli.finalLibrary.library.controller;

import gulas.saveli.finalLibrary.library.controller.builder.ThymeleafModelAndViewBuilder;
import gulas.saveli.finalLibrary.library.model.Book;
import gulas.saveli.finalLibrary.library.service.BookService;
import gulas.saveli.finalLibrary.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@RestController
@RequestMapping(path = "/api/book")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private final BookService bookService;
    @Autowired
    private final ThymeleafModelAndViewBuilder thymeleafModelAndViewBuilder;

    @GetMapping
    public ModelAndView defaultView() {
        return thymeleafModelAndViewBuilder.build("bookList");
    }

    @GetMapping(path = "{bookId}")
    public Book getById(@PathVariable("bookId") Long bookId) {
        return bookService.getById(bookId);
    }
}
