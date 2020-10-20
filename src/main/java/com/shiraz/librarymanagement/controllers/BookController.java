package com.shiraz.librarymanagement.controllers;

import com.shiraz.librarymanagement.domain.Book;
import com.shiraz.librarymanagement.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("{id}")
    public Book getBookById(@PathVariable("id") Long id){
        return bookService.getBookById(id);
    }

    @GetMapping("")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping("{id}")
    public Book deleteBook(@PathVariable("id") Long id) throws Exception{
        return bookService.deleteBook(id);
    }

    @PatchMapping("{id}")
    public Book updateBook(@PathVariable("id") Long id, @RequestBody Book book) throws Exception{
        return bookService.updateBook(id, book);
    }
}
