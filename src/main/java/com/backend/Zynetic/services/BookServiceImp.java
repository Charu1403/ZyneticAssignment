package com.backend.Zynetic.services;

import com.backend.Zynetic.dto.BookDTO;
import com.backend.Zynetic.entity.Book;
import com.backend.Zynetic.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService {

    private final BookRepository bookRepository;


    @Override
    public Book postBook(BookDTO bookDTO) {
        return saveOrUpdate(new Book(), bookDTO);
    }

    private Book saveOrUpdate(Book book, BookDTO bookDTO) {
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setCategory(bookDTO.getCategory());
        book.setPrice(bookDTO.getPrice());
        book.setRating(bookDTO.getRating());
        book.setPublishDate(bookDTO.getPublishDate());
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, BookDTO bookDTO) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return saveOrUpdate(book.get(), bookDTO);
        }
        else {
            throw new EntityNotFoundException("Book id doesn't exist");
        }
    }

    @Override
    public Book getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()){
            return book.get();
        }
        else {
            throw new EntityNotFoundException("Book id doesn't exist");
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll().stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.delete(book.get());
        }
        else {
            throw new EntityNotFoundException("Book id doesn't exist");
        }
    }

    @Override
    public List<Book> sortByPrice(String sortBy) {
        Sort.Direction direction = Sort.Direction.ASC;
        return bookRepository.findAll(Sort.by(direction, sortBy));
    }

    @Override
    public List<Book> sortByRating(String sortBy) {
        Sort.Direction direction = Sort.Direction.ASC;
        return bookRepository.findAll(Sort.by(direction, sortBy));
    }
}
