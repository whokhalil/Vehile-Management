package com.mukul.vehicle.io.service;

import com.mukul.vehicle.io.model.InvoiceStatus;
import com.mukul.vehicle.io.repository.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {

    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;

    public List<InvoiceStatus> getInvoiceStatus() {
        return invoiceStatusRepository.findAll();
    }

    public void save(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
    }

    public Optional<InvoiceStatus> findById(Integer id) {
        return invoiceStatusRepository.findById(id);
    }

    public void delete(Integer id) {
        invoiceStatusRepository.deleteById(id);
    }
}
