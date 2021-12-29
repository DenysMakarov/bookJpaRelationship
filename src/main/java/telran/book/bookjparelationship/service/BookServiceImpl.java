package telran.book.bookjparelationship.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import telran.book.bookjparelationship.dao.AuthorRepository;
import telran.book.bookjparelationship.dao.BookRepository;
import telran.book.bookjparelationship.dao.PublisherRepository;
import telran.book.bookjparelationship.dto.BookDto;
import telran.book.bookjparelationship.model.Author;
import telran.book.bookjparelationship.model.Book;
import telran.book.bookjparelationship.model.EntityNotFoundException;
import telran.book.bookjparelationship.model.Publisher;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    ModelMapper modelMapper;
    BookRepository bookRepository;
    AuthorRepository authorRepository;
    PublisherRepository publisherRepository;

    @Autowired
    public BookServiceImpl(ModelMapper modelMapper, BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.modelMapper = modelMapper;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    @Transactional
    public boolean addBook(BookDto bookDto) {
        if (bookRepository.existsById(bookDto.getIsbn())) return false;
        Publisher publisher = publisherRepository.findById(bookDto.getPublisher())
                .orElse(publisherRepository.save(new Publisher(bookDto.getPublisher())));
        Set<Author> authors = bookDto.getAuthors()
                .stream()
                .map(a -> authorRepository.findById(a.getName())
                        .orElse(authorRepository.save(new Author(a.getName(), a.getBirthDate()))))
                .collect(Collectors.toSet());
        Book book = new Book(bookDto.getIsbn(), bookDto.getTitle(), authors, publisher);
        bookRepository.save(book);
        return true;
    }

    @Override
    @Transactional
    public BookDto findBookByIsbn(String isbn) {
        Book book = bookRepository.findById(isbn).orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(book, BookDto.class);
    }
}
