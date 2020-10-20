package com.shiraz.librarymanagement.services;

import com.shiraz.librarymanagement.domain.Librarian;
import com.shiraz.librarymanagement.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianService {

    @Autowired
    private LibrarianRepository librarianRepository;

    //add Librarian
    public Librarian addLibrarian(Librarian librarian){
        return librarianRepository.save(librarian);
    }

    //get Librarian by Id
    public Librarian getLibrarianById(Long id){
        return librarianRepository.findById(id).get();
    }

    //get All librarians
    public List<Librarian> getAllLibrarians(){
        return librarianRepository.findAll();
    }

    //delete a librarian
    public Librarian deleteLibrarian(Long id) throws Exception{
        Librarian librarian = getLibrarianById(id);

        if (librarian == null){
            throw new Exception("Librarian does not exist");
        }

        librarianRepository.deleteById(id);
        return librarian;
    }

    //update a librarian
    public Librarian updateLibrarian(Long id, Librarian librarian) throws Exception{
        Librarian newLibrarian = getLibrarianById(id);

        if (newLibrarian == null){
            throw new Exception("Librarian does not exist");
        }

        if (newLibrarian.getName() != null){
            newLibrarian.setName(librarian.getName());
        }

        if (newLibrarian.getEmail() != null){
            newLibrarian.setEmail(librarian.getEmail());
        }

        if (newLibrarian.getDateOfBirth() != null){
            newLibrarian.setDateOfBirth(librarian.getDateOfBirth());
        }

        if (newLibrarian.getPassword() != null){
            newLibrarian.setPassword(librarian.getPassword());
        }

        if (newLibrarian.getEmploymentDate() != null){
            newLibrarian.setEmploymentDate(librarian.getEmploymentDate());
        }

        return librarianRepository.save(newLibrarian);
    }
}
