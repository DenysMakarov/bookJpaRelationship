package telran.book.bookjparelationship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import telran.book.bookjparelationship.dto.AuthorDto;
import telran.book.bookjparelationship.dto.BookDto;
import telran.book.bookjparelationship.model.Author;
import telran.book.bookjparelationship.service.BookService;

import java.util.Set;

@RestController
public class BookController {
    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public boolean addBook(@RequestBody BookDto bookDto){
        return bookService.addBook(bookDto);
    }

    @GetMapping("/book/{isbn}")
    public BookDto findBookByIsbn(@PathVariable String isbn){
        return bookService.findBookByIsbn(isbn);
    }

    @DeleteMapping("/book/{isbn}")
    public BookDto deleteBook(@PathVariable String isbn){
        return bookService.removeBook(isbn);
    }

    @PutMapping("/book/{isbn}/{title}")
    public BookDto deleteBook(@PathVariable String isbn, @PathVariable String title){
        return bookService.updateBook(isbn, title);
    }

    @GetMapping("/book/author/{author}")
    public Iterable<BookDto> findByAuthor(@PathVariable String author){
        return bookService.findByAuthor(author);
    }

    @GetMapping("/book/publisher/{publisher}")
    public Iterable<BookDto> findBookByPublisher(@PathVariable String publisher){
        return bookService.findBookByPublisher(publisher);
    }

    @GetMapping("/book/authors/{isbn}")
    public Set<Author> findAuthors(@PathVariable String isbn){
        return bookService.findBookAuthors(isbn);
    }

    @GetMapping("/publisher/authors/{author}")
    public Iterable<String> findPublishersByAuthor(@PathVariable String author){
        return bookService.findPublishersByAuthor(author);
    }

    @DeleteMapping("/author/{author}")
    public AuthorDto removeAuthor(@PathVariable String author){
        return bookService.removeAuthor(author);
    }
}
