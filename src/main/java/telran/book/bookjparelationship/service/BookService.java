package telran.book.bookjparelationship.service;

import telran.book.bookjparelationship.dto.AuthorDto;
import telran.book.bookjparelationship.dto.BookDto;
import telran.book.bookjparelationship.model.Author;

import java.util.Set;

public interface BookService {
    boolean addBook(BookDto bookDto);
    BookDto findBookByIsbn(String isbn);
    BookDto removeBook(String isbn);
    BookDto updateBook(String isbn, String title);
    Iterable<BookDto> findByAuthor(String authorName);
    Iterable<BookDto> findBookByPublisher(String publisherName);
    Set<Author> findBookAuthors(String isbn);
    Iterable<String> findPublishersByAuthor(String AuthorName); //все издатели у которых издавался данный автор
    AuthorDto removeAuthor(String authorName);
}
