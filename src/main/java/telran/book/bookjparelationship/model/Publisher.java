package telran.book.bookjparelationship.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"publisherName"})
@Entity
@ToString
public class Publisher  implements Serializable {
    private static final long serialVersionUID = 5687089701837669709L;
    @Id
    String publisherName;
}
