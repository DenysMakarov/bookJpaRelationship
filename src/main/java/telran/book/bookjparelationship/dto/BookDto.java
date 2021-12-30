package telran.book.bookjparelationship.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import telran.book.bookjparelationship.model.Publisher;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDto {
    String isbn;
    String title;
    Set<AuthorDto> authors;
    Publisher publisher;
}
