package com.example.testproject.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class PostDTO {


    private Long id;

    @NotNull(message = "Title cannot be null")
    @Size(min = 1, message = "Title must not be empty")
    private String title;

    @NotNull(message = "Description cannot be null")
    @Size(min = 1, message = "Description must not be empty")
    private String description;

    @NotNull(message = "Content cannot be null")
    @Size(min = 1, message = "Content must not be empty")
    private String content;

}
