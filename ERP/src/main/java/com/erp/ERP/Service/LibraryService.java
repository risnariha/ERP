package com.erp.ERP.Service;

import com.erp.ERP.Model.Library;
import com.erp.ERP.Repository.LibraryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    private final LibraryRepo libraryRepo;

    public LibraryService(LibraryRepo libraryRepo) {
        this.libraryRepo = libraryRepo;
    }

    public List<Library> getAllLibrary() {
        return libraryRepo.findAll();
    }

    public Library getLibraryById(Long id) {
        Optional<Library> library = libraryRepo.findById(id);
        return library.orElse(null);
    }

    public Library createLibrary(Library library) {
        return libraryRepo.save(library);
    }

    public Library updateLibrary(Long id, Library libraryDetails) {
        return libraryRepo.findById(id).map(library -> {
            // Example fields:
            library.setName(libraryDetails.getName());
            library.setLocation(libraryDetails.getLocation());
            // Add more fields as needed
            return libraryRepo.save(library);
        }).orElse(null);
    }

    public void deleteLibrary(Long id) {
        libraryRepo.deleteById(id);
    }
}
