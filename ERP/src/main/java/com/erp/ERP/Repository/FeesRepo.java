package com.erp.ERP.Repository;


import com.erp.ERP.Model.Fees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeesRepo extends JpaRepository<Fees, Long> {
    // You can add custom query methods here if needed
}
