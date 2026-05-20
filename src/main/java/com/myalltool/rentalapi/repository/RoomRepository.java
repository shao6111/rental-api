package com.myalltool.rentalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myalltool.rentalapi.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}