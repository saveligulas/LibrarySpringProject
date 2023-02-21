package gulas.saveli.finalLibrary.repo;

import gulas.saveli.finalLibrary.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
