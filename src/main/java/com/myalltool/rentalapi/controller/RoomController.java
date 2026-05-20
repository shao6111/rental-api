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

import com.myalltool.rentalapi.model.Room;
import com.myalltool.rentalapi.repository.RoomRepository;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "*")
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    // 查詢全部房間
    @GetMapping
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // 新增房間
    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomRepository.save(room);
    }

    // 查詢單一房間
    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("找不到房間資料"));
    }

    // 修改房間資料
@PutMapping("/{id}")
public Room updateRoom(@PathVariable Long id, @RequestBody Room updatedRoom) {
    Room room = roomRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("找不到房間資料"));

    room.setRoomNo(updatedRoom.getRoomNo());
    room.setRoomType(updatedRoom.getRoomType());
    room.setRent(updatedRoom.getRent());
    room.setDeposit(updatedRoom.getDeposit());
    room.setStatus(updatedRoom.getStatus());
    room.setTenantName(updatedRoom.getTenantName());
    room.setTenantPhone(updatedRoom.getTenantPhone());
    room.setContractStartDate(updatedRoom.getContractStartDate());
    room.setContractEndDate(updatedRoom.getContractEndDate());
    room.setNote(updatedRoom.getNote());

    return roomRepository.save(room);
}


    // 刪除房間
    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomRepository.deleteById(id);
    }
}