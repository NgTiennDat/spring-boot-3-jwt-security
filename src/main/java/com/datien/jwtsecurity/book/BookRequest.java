package com.datien.jwtsecurity.book;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {
    @NotBlank(message = "title is mandatory")
    private String title;

    @NotBlank(message = "author name is mandatory")
    private String authorName;

    @NotBlank(message = "publisher is mandatory")
    private String publisher;
    private String synopsis;
    private boolean available;
}
