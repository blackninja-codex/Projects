package com.example.medical.controller;

import com.example.medical.model.RecordModel;
import com.example.medical.service.RecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/Records")
@RestController
public class RecordController {
    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping
    public List<RecordModel> getAllRooms() {
        return recordService.getAllRecords();
    }


    @GetMapping("/getRecord/{pid}")
    public RecordModel getRecord(@PathVariable String pid) {
        return recordService.getRecord(pid);
    }

    @PostMapping("/createRecord")
    public RecordModel createRecord(@RequestBody RecordModel recordModel) {
        return recordService.createRecord(recordModel);
    }

    @DeleteMapping("/deleteRecord/{pid}")
    public String deleteRecord(@PathVariable String pid) {
        recordService.deleteRecord(pid);
        return " Patient Record with pid : " + pid+ " Deleted";
    }

    @PutMapping("/updateRecord/{pid}")
    public RecordModel updateRoom(@RequestBody RecordModel recordModel, @PathVariable String pid) {
        return recordService.updateRecord(recordModel, pid);
    }

    @DeleteMapping("/deleteAllRecords")
    public String deleteAllRecords() {
        recordService.deleteAllRecords();
        return "All Patient Records data deleted";
    }

}
