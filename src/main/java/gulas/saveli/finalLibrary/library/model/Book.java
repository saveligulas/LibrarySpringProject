package gulas.saveli.finalLibrary.library.model;

import gulas.saveli.finalLibrary.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany
    @JoinTable(
            name = "book_genres",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;
    @Setter(AccessLevel.NONE)private LocalDate dor;
    @Setter(AccessLevel.NONE)private Boolean available;

    public void setDor(LocalDate dor) {
        this.available = dor == null;
        this.dor = dor;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
