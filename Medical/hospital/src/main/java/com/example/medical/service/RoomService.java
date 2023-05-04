package com.example.medical.service;

import com.example.medical.model.RoomModel;
import com.example.medical.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {


    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<RoomModel> getAllRooms() {
        return roomRepository.findAll();
    }

    public RoomModel getRoom(String rid) {
        return roomRepository.findById(rid).orElse(null);
    }


    public RoomModel createRoom(RoomModel roomModel) {
        return roomRepository.save(roomModel);
    }

    public void deleteRoom(String rid) {
        roomRepository.deleteById(rid);
    }

    public RoomModel updateRoom(RoomModel roomModel, String rid) {
        RoomModel roomModel1 = roomRepository.findById(rid).get();
        roomModel1.setPid(roomModel.getPid());
        roomModel1.setOccupied(roomModel.getOccupied());
        roomRepository.save(roomModel1);
        return roomModel1;
    }

    public void deleteAllRooms() {
        roomRepository.deleteAll();
    }

}
