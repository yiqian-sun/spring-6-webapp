package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setFirstName("Savannah");
        author.setLastName("Sun");

        Book book = new Book();
        book.setTitle("I'm a piece of shit");
        book.setIsbn("000000");

        Author authorSave = authorRepository.save(author);
        Book bookSava = bookRepository.save(book);

        Author Qiang = new Author();
        author.setFirstName("Yongqiang");
        author.setLastName("Zuo");

        Book book1 = new Book();
        book.setTitle("When can I find a job");
        book.setIsbn("000001");

        Author qiangSave = authorRepository.save(Qiang);
        Book book1Sava = bookRepository.save(book1);

        authorSave.getBooks().add(bookSava);
        qiangSave.getBooks().add(book1Sava);

        authorRepository.save(author);
        authorRepository.save(qiangSave);

        Publisher publisher = new Publisher();
        publisher.setAddress("160 pleasant st.");
        publisher.setCity("Malden");
        publisher.setZip("02148");
        publisher.setPublisherName("911");
        publisher.setState("MA");
        Publisher p = publisherRepository.save(publisher);
        bookSava.setPublisher(p);
        book1Sava.setPublisher(p);


        System.out.println("In bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
        System.out.println(publisher);
    }
}
