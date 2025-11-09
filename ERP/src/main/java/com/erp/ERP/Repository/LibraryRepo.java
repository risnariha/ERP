package com.erp.ERP.Repository;

import com.erp.ERP.Model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepo extends JpaRepository<Library, Long> {
    // Add custom query methods if needed
}
