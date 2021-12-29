package telran.book.bookjparelationship.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import telran.book.bookjparelationship.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {

}
