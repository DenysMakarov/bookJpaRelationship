package telran.book.bookjparelationship.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDto {
    String isbn;
    String title;
    Set<AuthorDto> authors;
    String publisher;
}
