package telran.book.bookjparelationship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import telran.book.bookjparelationship.dto.BookDto;
import telran.book.bookjparelationship.service.BookService;

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
}
