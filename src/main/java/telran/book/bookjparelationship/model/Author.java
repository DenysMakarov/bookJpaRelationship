package telran.book.bookjparelationship.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"name"})
@Entity
public class Author implements Serializable {
    private static final long serialVersionUID = 1032782494037407673L;
    @Id
    String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;
}
