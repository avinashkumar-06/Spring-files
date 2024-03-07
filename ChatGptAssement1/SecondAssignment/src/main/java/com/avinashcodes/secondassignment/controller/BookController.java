package com.avinashcodes.secondassignment.controller;

import com.avinashcodes.secondassignment.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BookController {

    // I am using Book object and using initializing block to add some books in the list
    // But in real world we will be using database to store the books
    private static List<Book> bookInDB;

     {
       bookInDB = new ArrayList<>();
       bookInDB.add(new Book(1,"Java","IN456456",200,"Avinash"));
       bookInDB.add(new Book(2,"python","IN459635",280,"Avinash"));
       bookInDB.add(new Book(3,"c++","IN451478",190,"Devesh"));
       bookInDB.add(new Book(4,"react","IN454521",195,"Riyas"));
       bookInDB.add(new Book(5,"spring","IN457894",100,"Avinash"));
    }


    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book){

       bookInDB.add(book);

       return new ResponseEntity<>(book, HttpStatus.CREATED);

    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookByID(@PathVariable("id") Integer bookID){

       Book bookFound = bookInDB.stream().filter(book -> book.getBookID() == bookID).findFirst().orElse(null);
       return new ResponseEntity<>(bookFound,HttpStatus.OK);
    }


    @PutMapping("/books/{id}")
    public ResponseEntity<List<Book>> updateBook(@RequestBody Book book,@PathVariable("id") Integer bookID){

         // use stream to update the book and return the updated book list
            bookInDB = bookInDB.stream().map(book1 -> {
                if(book1.getBookID() == bookID){
                    book1.setBookName(book.getBookName());
                    book1.setIsbnNumber(book.getIsbnNumber());
                    book1.setNumberOfPages(book.getNumberOfPages());
                    book1.setAuthorName(book.getAuthorName());
                }
                return book1;
            }).collect(Collectors.toList());



         return new ResponseEntity<>(bookInDB,HttpStatus.OK);
    }


    @DeleteMapping("/books/{id}")
    public ResponseEntity<List<Book>> deleteBook(@PathVariable("id") Integer bookID){

        bookInDB = bookInDB.stream().filter(book -> book.getBookID() != bookID).collect(Collectors.toList());
        return new ResponseEntity<>(bookInDB,HttpStatus.OK);


    }




}
