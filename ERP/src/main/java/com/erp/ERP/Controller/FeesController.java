package com.erp.ERP.Controller;


import com.erp.ERP.Model.Fees;
import com.erp.ERP.Service.FeesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fees")
public class FeesController {

    private final FeesService feesService;

    public FeesController(FeesService feesService) {
        this.feesService = feesService;
    }

    @GetMapping
    public List<Fees> getAllFees() {
        return feesService.getAllFees();
    }

    @GetMapping("/{id}")
    public Fees getFeesById(@PathVariable Long id) {
        return feesService.getFeesById(id);
    }

    @PostMapping
    public Fees createFees(@RequestBody Fees fees) {
        return feesService.createFees(fees);
    }

    @PutMapping("/{id}")
    public Fees updateFees(@PathVariable Long id, @RequestBody Fees fees) {
        return feesService.updateFees(id, fees);
    }

    @DeleteMapping("/{id}")
    public void deleteFees(@PathVariable Long id) {
        feesService.deleteFees(id);
    }
}
