package com.myalltool.rentalapi.repository;

import com.myalltool.rentalapi.model.RoomPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoomPhotoRepository extends JpaRepository<RoomPhoto, Long> {

    List<RoomPhoto> findByRoomIdOrderByCreatedAtDesc(Long roomId);
}