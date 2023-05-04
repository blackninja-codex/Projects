package com.example.medical.controller;

import com.example.medical.model.PatientModel;
import com.example.medical.model.RecordModel;
import com.example.medical.model.DoctorModel;
import com.example.medical.model.RoomModel;
import com.example.medical.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/Patients")
@RestController
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientModel> getAllPatients() {
        return patientService.getAllPatients();
    }


    @GetMapping("/getPatient/{pid}")
    public PatientModel getPatient(@PathVariable String pid) {
        return patientService.getPatient(pid);
    }
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/getPatientRecord/{pid}")
    public RecordModel getPatientRecord(@PathVariable String pid){
        RecordModel patientRecord = restTemplate.getForObject("http://RECORD/Records/getRecord/"+pid, RecordModel.class);
        return patientRecord;
    }


    @GetMapping("/getPatientDoctor/{pid}")
    public DoctorModel getPatientDoctor(@PathVariable String pid){
        String did = patientService.getDidByPid(pid);

        DoctorModel doctorDetails = restTemplate.getForObject("http://DOCTOR/Doctors/getDoctor/"+did, DoctorModel.class);
        return doctorDetails;
    }
    @GetMapping("/getPatientRoom/{pid}")
    public RoomModel getPatientRoom(@PathVariable String pid){
        String rid = patientService.getRidByPid(pid);

        RoomModel roomDetails = restTemplate.getForObject("http://ROOM/Rooms/getRoom/"+rid, RoomModel.class);
        return roomDetails;
    }
    @PostMapping("/createPatient")
    public PatientModel createPatient(@RequestBody PatientModel patientModel) {
        return patientService.createPatient(patientModel);
    }

    @DeleteMapping("/deletePatient/{pid}")
    public String deletePatient(@PathVariable String pid) {
        patientService.deletePatient(pid);
        return "Patient with pid : " + pid+ " Deleted";
    }

    @PutMapping("/updatePatient/{pid}")
    public PatientModel updatePatient(@RequestBody PatientModel patientModel, @PathVariable String pid) {
        return patientService.updatePatient(patientModel, pid);
    }

    @DeleteMapping("/deleteAllPatients")
    public String deleteAllPatients() {
        patientService.deleteAllPatients();
        return "All patients data deleted";
    }

}
