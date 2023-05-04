package com.example.medical.controller;

import com.example.medical.model.DoctorModel;

import com.example.medical.service.DoctorService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/Doctors")
@RestController
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<DoctorModel> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/getDoctor/{did}")
    public DoctorModel getDoctor(@PathVariable String did) {
        return doctorService.getDoctor(did);
    }

    @PostMapping("/createDoctor")
    public DoctorModel createDoctor(@RequestBody DoctorModel doctorModel) {
        return doctorService.createDoctor(doctorModel);
    }


    @DeleteMapping("/deleteDoctor/{did}")
    public String deleteDoctor(@PathVariable String did) {
        doctorService.deleteDoctor(did);
        return "Doctor with id : " + did+ " Deleted";
    }

    @PutMapping("/updateDoctor/{did}")
    public DoctorModel updateDoctor(@RequestBody DoctorModel doctorModel, @PathVariable String did) {
        return doctorService.updateDoctor(doctorModel, did);
    }

    @DeleteMapping("/deleteAllDoctors")
    public String deleteAllDoctors() {
        doctorService.deleteAllDoctors();
        return "All Books data deleted";
    }

}
