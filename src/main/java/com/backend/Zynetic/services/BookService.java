package com.backend.Zynetic.services;

import com.backend.Zynetic.dto.BookDTO;
import com.backend.Zynetic.entity.Book;
import org.springframework.data.domain.Sort;

import java.util.List;


public interface BookService {
    Book postBook(BookDTO bookDTO);
    Book updateBook(Long id, BookDTO bookDTO);
    Book getBookById(Long id);
    List<Book> getAllBooks();
    void deleteBook(Long id);
    List<Book> sortByPrice(String sort);
    List<Book> sortByRating(String sort);
}
