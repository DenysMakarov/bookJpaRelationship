package telran.book.bookjparelationship.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import telran.book.bookjparelationship.model.Publisher;

import java.util.Set;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, String> {
    @Query("select distinct p.publisherName from Book b join b.authors a join b.publisher p where a.name=?1")
    Set<String> findPublisherByAuthor(String authorName);
}
