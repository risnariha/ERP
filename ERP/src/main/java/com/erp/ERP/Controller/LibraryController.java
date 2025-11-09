package com.erp.ERP.Controller;

import com.erp.ERP.Model.Library;
import com.erp.ERP.Service.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public List<Library> getAllLibrary() {
        return libraryService.getAllLibrary();
    }

    @GetMapping("/{id}")
    public Library getLibraryById(@PathVariable Long id) {
        return libraryService.getLibraryById(id);
    }

    @PostMapping
    public Library createLibrary(@RequestBody Library library) {
        return libraryService.createLibrary(library);
    }

    @PutMapping("/{id}")
    public Library updateLibrary(@PathVariable Long id, @RequestBody Library library) {
        return libraryService.updateLibrary(id, library);
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable Long id) {
        libraryService.deleteLibrary(id);
    }
}
