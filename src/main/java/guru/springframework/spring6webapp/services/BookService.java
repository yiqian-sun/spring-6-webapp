package guru.springframework.spring6webapp.services;

import guru.springframework.spring6webapp.domain.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    public Iterable<Book> findAll();
}
