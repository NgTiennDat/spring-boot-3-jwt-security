package com.datien.jwtsecurity.book;

public record BookDto(
    String title,
    String authorName,
    String publisher,
    String synopsis,
    boolean available
) {
}
