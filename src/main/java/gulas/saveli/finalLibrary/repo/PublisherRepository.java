package gulas.saveli.finalLibrary.repo;

import gulas.saveli.finalLibrary.library.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
