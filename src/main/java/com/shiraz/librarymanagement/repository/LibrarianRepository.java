package com.shiraz.librarymanagement.repository;

import com.shiraz.librarymanagement.domain.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
}
