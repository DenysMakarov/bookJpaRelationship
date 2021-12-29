package telran.book.bookjparelationship.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorDto {
    String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;
}
