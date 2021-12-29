package telran.book.bookjparelationship.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"isbn"})
@Entity
public class Book implements Serializable {
    private static final long serialVersionUID = 6297926166935503683L;

    @Id
    String isbn;
    String title;
    @ManyToMany
    Set<Author> authors;
    @ManyToOne
    Publisher publisher;
}
