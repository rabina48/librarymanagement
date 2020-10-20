package com.shiraz.librarymanagement.services;

import com.shiraz.librarymanagement.domain.Book;
import com.shiraz.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    //add a Book
    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    //get book by Id
    public Book getBookById(Long id){
        return bookRepository.findById(id).get();
    }

    //get all books
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    //delete a book
    public Book deleteBook(Long id) throws Exception{
        Book book = getBookById(id);
        if (book == null){
            throw new Exception("Book doesn't exist");
        }

        bookRepository.deleteById(id);
        return book;
    }

    //update a book
    public Book updateBook(Long id, Book book) throws Exception{
        Book newBook = getBookById(id);

        if (newBook == null){
            throw new Exception("Book doesn't exist");
        }

        if (newBook.getTitle() != null){
            newBook.setTitle(book.getTitle());
        }

        if (newBook.getIsbn() != null){
            newBook.setIsbn(book.getIsbn());
        }

        if (newBook.getAuthor() != null){
            newBook.setAuthor(book.getAuthor());
        }

        if (newBook.getCategory() != null){
            newBook.setCategory(book.getAuthor());
        }

        if (newBook.getNumberOfPages() >= 0){
            newBook.setNumberOfPages(book.getNumberOfPages());
        }

        return bookRepository.save(newBook);
    }
}
