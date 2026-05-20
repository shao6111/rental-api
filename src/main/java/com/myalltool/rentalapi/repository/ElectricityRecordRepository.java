package com.myalltool.rentalapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myalltool.rentalapi.model.ElectricityRecord;

public interface ElectricityRecordRepository extends JpaRepository<ElectricityRecord, Long> {

    List<ElectricityRecord> findByRoomId(Long roomId);
}