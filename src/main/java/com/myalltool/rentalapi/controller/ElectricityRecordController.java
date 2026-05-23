package com.myalltool.rentalapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myalltool.rentalapi.model.ElectricityRecord;
import com.myalltool.rentalapi.repository.ElectricityRecordRepository;

@RestController
@RequestMapping("/api/electricity-records")
@CrossOrigin(origins = "*")
public class ElectricityRecordController {

    private final ElectricityRecordRepository electricityRecordRepository;

    public ElectricityRecordController(ElectricityRecordRepository electricityRecordRepository) {
        this.electricityRecordRepository = electricityRecordRepository;
    }

    // 查詢全部電費紀錄
    @GetMapping
    public List<ElectricityRecord> getAllRecords() {
        return electricityRecordRepository.findAll();
    }

    // 依房間 ID 查詢電費紀錄
    @GetMapping("/room/{roomId}")
    public List<ElectricityRecord> getRecordsByRoomId(@PathVariable Long roomId) {
        return electricityRecordRepository.findByRoomId(roomId);
    }

        // 新增電費紀錄
    @PostMapping("/room/{roomId}")
    public ElectricityRecord createRecord(
            @PathVariable Long roomId,
            @RequestBody ElectricityRecord record
    ) {
        record.setRoomId(roomId);

    if (record.getPreviousReading() != null && record.getCurrentReading() != null) {
        int usedUnits = record.getCurrentReading() - record.getPreviousReading();
        record.setUsedUnits(usedUnits);

        if (record.getPricePerUnit() != null) {
            record.setTotalAmount(usedUnits * record.getPricePerUnit());
        }
    }

    return electricityRecordRepository.save(record);
}

    // 修改電費紀錄
    @PutMapping("/{id}")
    public ElectricityRecord updateRecord(@PathVariable Long id, @RequestBody ElectricityRecord updatedRecord) {
        ElectricityRecord record = electricityRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("找不到電費紀錄"));

        record.setRoomId(updatedRecord.getRoomId());
        record.setRecordMonth(updatedRecord.getRecordMonth());
        record.setPreviousReading(updatedRecord.getPreviousReading());
        record.setCurrentReading(updatedRecord.getCurrentReading());
        record.setPricePerUnit(updatedRecord.getPricePerUnit());
        record.setNote(updatedRecord.getNote());

        if (updatedRecord.getPreviousReading() != null && updatedRecord.getCurrentReading() != null) {
            int usedUnits = updatedRecord.getCurrentReading() - updatedRecord.getPreviousReading();
            record.setUsedUnits(usedUnits);

            if (updatedRecord.getPricePerUnit() != null) {
                record.setTotalAmount(usedUnits * updatedRecord.getPricePerUnit());
            }
        }

        return electricityRecordRepository.save(record);
    }

    // 刪除電費紀錄
    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable Long id) {
        electricityRecordRepository.deleteById(id);
    }
}