package com.backend.Zynetic.controller;


import com.backend.Zynetic.dto.BookDTO;
import com.backend.Zynetic.entity.Book;
import com.backend.Zynetic.services.BookService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@CrossOrigin("*")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<?> postBook(@RequestBody BookDTO bookDTO) {
        Book createdBook = bookService.postBook(bookDTO);
        if (createdBook != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(bookService.getBookById(id));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id ,@RequestBody BookDTO bookDTO) {
        try{
            return ResponseEntity.ok(bookService.updateBook(id, bookDTO));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable Long id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.ok(null);
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @GetMapping("/SortPrice")
    public ResponseEntity<?> sortByPrice(String sort) {
        return ResponseEntity.ok(bookService.sortByPrice(sort));
    }

    @GetMapping("/SortRating")
    public ResponseEntity<?> sortByRating(String sort) {
        return ResponseEntity.ok(bookService.sortByRating(sort));
    }
}
