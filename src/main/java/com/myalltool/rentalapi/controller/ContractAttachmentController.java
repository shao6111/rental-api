package com.myalltool.rentalapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myalltool.rentalapi.model.ContractAttachment;
import com.myalltool.rentalapi.repository.ContractAttachmentRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ContractAttachmentController {

    private final ContractAttachmentRepository contractAttachmentRepository;

    public ContractAttachmentController(ContractAttachmentRepository contractAttachmentRepository) {
        this.contractAttachmentRepository = contractAttachmentRepository;
    }

    @GetMapping("/rooms/{roomId}/contracts")
    public List<ContractAttachment> getContractsByRoomId(@PathVariable Long roomId) {
        return contractAttachmentRepository.findByRoomId(roomId);
    }

    @PostMapping("/rooms/{roomId}/contracts")
    public ContractAttachment addContract(
            @PathVariable Long roomId,
            @RequestBody ContractAttachment contractAttachment
    ) {
        contractAttachment.setRoomId(roomId);
        return contractAttachmentRepository.save(contractAttachment);
    }

    @DeleteMapping("/contract-attachments/{id}")
    public void deleteContract(@PathVariable Long id) {
        contractAttachmentRepository.deleteById(id);
    }
}