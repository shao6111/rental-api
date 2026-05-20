package com.myalltool.rentalapi.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "electricity_record")
public class ElectricityRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 房間 ID
    @Column(nullable = false)
    private Long roomId;

    // 紀錄月份，例如 2026-05-01
    private LocalDate recordMonth;

    // 上期電表度數
    private Integer previousReading;

    // 本期電表度數
    private Integer currentReading;

    // 每度電費
    private Double pricePerUnit;

    // 使用度數
    private Integer usedUnits;

    // 應繳電費
    private Double totalAmount;

    private String note;

    public Long getId() {
        return id;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public LocalDate getRecordMonth() {
        return recordMonth;
    }

    public void setRecordMonth(LocalDate recordMonth) {
        this.recordMonth = recordMonth;
    }

    public Integer getPreviousReading() {
        return previousReading;
    }

    public void setPreviousReading(Integer previousReading) {
        this.previousReading = previousReading;
    }

    public Integer getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(Integer currentReading) {
        this.currentReading = currentReading;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Integer getUsedUnits() {
        return usedUnits;
    }

    public void setUsedUnits(Integer usedUnits) {
        this.usedUnits = usedUnits;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}