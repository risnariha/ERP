package com.erp.ERP.Service;



import com.erp.ERP.Model.Payroll;
import com.erp.ERP.Repository.PayrollRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollService {

    private final PayrollRepo payrollRepo;

    public PayrollService(PayrollRepo payrollRepo) {
        this.payrollRepo = payrollRepo;
    }

    public List<Payroll> getAllPayrolls() {
        return payrollRepo.findAll();
    }

    public Payroll getPayrollById(Long id) {
        Optional<Payroll> payroll = payrollRepo.findById(id);
        return payroll.orElse(null);
    }

    public Payroll createPayroll(Payroll payroll) {
        return payrollRepo.save(payroll);
    }

    public Payroll updatePayroll(Long id, Payroll payrollDetails) {
        return payrollRepo.findById(id).map(payroll -> {
            payroll.setStaffId(payrollDetails.getStaffId());
            payroll.setSalary(payrollDetails.getSalary());
            payroll.setDeduction(payrollDetails.getDeduction());
            payroll.setNetPay(payrollDetails.getNetPay());
            payroll.setPayDate(payrollDetails.getPayDate());
            return payrollRepo.save(payroll);
        }).orElse(null);
    }

    public void deletePayroll(Long id) {
        payrollRepo.deleteById(id);
    }
}
