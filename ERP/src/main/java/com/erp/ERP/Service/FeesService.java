package com.erp.ERP.Service;


import com.erp.ERP.Model.Fees;
import com.erp.ERP.Repository.FeesRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeesService {

    private final FeesRepo feesRepo;

    public FeesService(FeesRepo feesRepo) {
        this.feesRepo = feesRepo;
    }

    public List<Fees> getAllFees() {
        return feesRepo.findAll();
    }

    public Fees getFeesById(Long id) {
        Optional<Fees> fees = feesRepo.findById(id);
        return fees.orElse(null);
    }

    public Fees createFees(Fees fees) {
        return feesRepo.save(fees);
    }

    public Fees updateFees(Long id, Fees feesDetails) {
        return feesRepo.findById(id).map(fees -> {
            fees.setAmount(feesDetails.getAmount());
            fees.setStatus(feesDetails.getStatus());
            // Any other fields
            return feesRepo.save(fees);
        }).orElse(null);
    }

    public void deleteFees(Long id) {
        feesRepo.deleteById(id);
    }
}
