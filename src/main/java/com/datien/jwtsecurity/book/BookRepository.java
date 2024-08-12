package com.datien.jwtsecurity.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("""
           SELECT book
           FROM Book book
           WHERE book.authorName = :authorName
        """)
    Optional<Book> findBookByAuthor(String authorName);
}
