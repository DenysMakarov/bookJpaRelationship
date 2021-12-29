package telran.book.bookjparelationship.service;

import org.springframework.stereotype.Service;
import telran.book.bookjparelationship.dto.BookDto;

public interface BookService {
    boolean addBook(BookDto bookDto);
    BookDto findBookByIsbn(String isbn);
}
