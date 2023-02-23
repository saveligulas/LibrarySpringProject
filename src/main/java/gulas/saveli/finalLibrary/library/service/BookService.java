package gulas.saveli.finalLibrary.library.service;

import gulas.saveli.finalLibrary.library.errorHandler.exception.NameAlreadyTakenException;
import gulas.saveli.finalLibrary.library.model.Book;
import gulas.saveli.finalLibrary.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.NameAlreadyBoundException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Collection<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException("Book with id " + bookId + " does not exist"));
    }

    public void save(Book book) {
        Optional<Book> bookOptional = bookRepository.findBookByName(book.getName());
        if(bookOptional.isPresent()) {
            throw new IllegalStateException("Book with name " + book.getName() + " already exists");
        }
        bookRepository.save(book);
    }

    public void deleteById(Long id) {
        if(!bookRepository.existsById(id)) {
            throw new IllegalStateException("Book with id " + id + " does not exist");
        }
        bookRepository.deleteById(id);
    }

    public List<Book> getUnavailableBooks() {
        return bookRepository.findByAvailableFalse();
    }

    public List<Book> getAvailableBooks() {
        return bookRepository.findByAvailableTrue();
    }

    @Transactional
    public void editBook(Long bookId, String name, Long genreId, List<Long> genreIdList, Long authorId, Long publisherId) throws NameAlreadyTakenException {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException("Book with id " + bookId + " does not exist"));

        if(name != null &&
                name.length() > 0 &&
                !name.equals(book.getName())) {
            Optional<Book> bookOptional = bookRepository.findBookByName(name);
            if(bookOptional.isPresent()) {
                throw new NameAlreadyTakenException("Book with name " + name + " already exists");
            }
            book.setName(name);
        }
    }
}
