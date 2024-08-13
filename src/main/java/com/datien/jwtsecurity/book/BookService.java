package com.datien.jwtsecurity.book;

import com.datien.jwtsecurity.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public void savedBook(BookRequest request, Authentication connectedUser) {
        User user = (User) connectedUser.getPrincipal();
        Book book = bookMapper.toBook(request);
        book.setCreateDate(LocalDateTime.now());
        book.setCreatedBy(user.getId());
        bookRepository.save(book);
    }

    public List<BookResponse> getAllBooks(Authentication connectedUser) {
        User user = (User) connectedUser.getPrincipal();
        if(user == null) {
            throw new RuntimeException("Exception occurred!");
        }
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toBookResponse)
                .collect(Collectors.toList());
    }
}
