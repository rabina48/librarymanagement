package com.shiraz.librarymanagement.controllers;

import com.shiraz.librarymanagement.domain.Librarian;
import com.shiraz.librarymanagement.services.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/librarians")
public class LibrarianController {

    @Autowired
    private LibrarianService librarianService;

    @GetMapping("{id}")
    public Librarian getLibrarianById(@PathVariable("id") Long id){
        return librarianService.getLibrarianById(id);
    }

    @GetMapping("")
    public List<Librarian> getAllLibrarians(){
        return librarianService.getAllLibrarians();
    }

    @PostMapping("")
    public Librarian addLibrarian(@RequestBody Librarian librarian){
        return librarianService.addLibrarian(librarian);
    }

    @DeleteMapping("{id}")
    public Librarian deleteLibrarian(@PathVariable("id") Long id) throws Exception{
        return librarianService.deleteLibrarian(id);
    }

    @PatchMapping("{id}")
    public Librarian updateLibrarian(@PathVariable("id") Long id, @RequestBody Librarian librarian) throws Exception{
        return librarianService.updateLibrarian(id, librarian);
    }
}
