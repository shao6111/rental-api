package com.myalltool.rentalapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myalltool.rentalapi.model.ContractAttachment;

public interface ContractAttachmentRepository extends JpaRepository<ContractAttachment, Long> {

    List<ContractAttachment> findByRoomId(Long roomId);
}