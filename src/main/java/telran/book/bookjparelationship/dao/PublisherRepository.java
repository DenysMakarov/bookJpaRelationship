package telran.book.bookjparelationship.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import telran.book.bookjparelationship.model.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, String> {
}
