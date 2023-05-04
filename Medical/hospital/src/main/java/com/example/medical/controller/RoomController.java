package com.example.medical.controller;

import com.example.medical.model.RoomModel;
import com.example.medical.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/Rooms")
@RestController
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<RoomModel> getAllRooms() {
        return roomService.getAllRooms();
    }


    @GetMapping("/getRoom/{rid}")
    public RoomModel getRoom(@PathVariable String rid) {
        return roomService.getRoom(rid);
    }

    @PostMapping("/createRoom")
    public RoomModel createRoom(@RequestBody RoomModel roomModel) {
        return roomService.createRoom(roomModel);
    }

    @DeleteMapping("/deleteRoom/{rid}")
    public String deleteRoom(@PathVariable String rid) {
        roomService.deleteRoom(rid);
        return "Room with rid : " + rid+ " Deleted";
    }

    @PutMapping("/updateRoom/{rid}")
    public RoomModel updateRoom(@RequestBody RoomModel roomModel, @PathVariable String rid) {
        return roomService.updateRoom(roomModel, rid);
    }

    @DeleteMapping("/deleteAllRooms")
    public String deleteAllRooms() {
        roomService.deleteAllRooms();
        return "All Room data deleted";
    }

}
