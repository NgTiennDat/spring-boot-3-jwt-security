package com.datien.jwtsecurity.book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponse {
    private String title;
    private String authorName;
    private String publisher;
    private String synopsis;
    private boolean available;
}