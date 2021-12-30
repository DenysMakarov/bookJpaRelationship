package telran.book.bookjparelationship.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import telran.book.bookjparelationship.dto.BookDto;
import telran.book.bookjparelationship.model.Book;
import telran.book.bookjparelationship.model.Publisher;

import java.util.stream.Stream;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
//    @Query("select p from Person p where p.address.city=:cities")
//    Stream<Person> findAllByAddressCity(@Param("cities") String cities);

    Stream<Book> findByAuthorsName(String authors);

    @Query("select b from Book b where b.publisher.publisherName=:publisher")
    Stream<Book> findBooksByPublisher(@Param("publisher") String publisher);
}
