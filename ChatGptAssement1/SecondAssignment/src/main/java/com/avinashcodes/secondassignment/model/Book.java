package com.avinashcodes.secondassignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private int bookID;

    private String bookName;

    private String isbnNumber;

    private int numberOfPages;

    private String authorName;





}
