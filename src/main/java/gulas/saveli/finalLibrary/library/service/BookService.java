package gulas.saveli.finalLibrary.library.service;

import gulas.saveli.library4.Interfaces.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class BookService implements LibraryService<Book> {
    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public Collection<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException("Book with id " + bookId + " does not exist"));
    }

    @Override
    public Book save(Book book) {
        Optional<Book> bookOptional = bookRepository.findBookByName(book.getName());
        if(bookOptional.isPresent()) {
            throw new IllegalStateException("Book with name " + book.getName() + " already exists");
        }
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book deleteById(Long id) {
        if(!bookRepository.existsById(id)) {
            throw new IllegalStateException("Book with id " + id + " does not exist");
        }
        bookRepository.deleteById(id);
        return null;
    }
}
