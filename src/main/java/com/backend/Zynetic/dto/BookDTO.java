package com.backend.Zynetic.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDTO {

    private String title;
    private String author;
    private String category;
    private Double price;
    private Double rating;
    private LocalDate publishDate;
}
