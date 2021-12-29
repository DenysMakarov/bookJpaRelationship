package telran.book.bookjparelationship.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import telran.book.bookjparelationship.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

}
