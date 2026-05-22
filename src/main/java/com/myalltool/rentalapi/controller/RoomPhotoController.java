package com.myalltool.rentalapi.controller;

import com.myalltool.rentalapi.model.RoomPhoto;
import com.myalltool.rentalapi.repository.RoomPhotoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RoomPhotoController {

    private final RoomPhotoRepository roomPhotoRepository;

    public RoomPhotoController(RoomPhotoRepository roomPhotoRepository) {
        this.roomPhotoRepository = roomPhotoRepository;
    }

    @GetMapping("/rooms/{roomId}/photos")
    public List<RoomPhoto> getPhotosByRoom(@PathVariable Long roomId) {
        return roomPhotoRepository.findByRoomIdOrderByCreatedAtDesc(roomId);
    }

    @PostMapping("/rooms/{roomId}/photos")
    public RoomPhoto addPhoto(
            @PathVariable Long roomId,
            @RequestBody RoomPhoto roomPhoto
    ) {
        roomPhoto.setRoomId(roomId);
        return roomPhotoRepository.save(roomPhoto);
    }

    @DeleteMapping("/room-photos/{photoId}")
    public void deletePhoto(@PathVariable Long photoId) {
        roomPhotoRepository.deleteById(photoId);
    }
}