package gulas.saveli.finalLibrary.repo;

import gulas.saveli.finalLibrary.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
