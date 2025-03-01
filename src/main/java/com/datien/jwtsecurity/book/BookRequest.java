package com.datien.jwtsecurity.book;

import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private String authorName;
    private String authorEmail;
    private String publisher;
    private String synopsis;
    private boolean available;
}
