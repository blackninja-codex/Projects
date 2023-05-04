package com.example.medical.service;

import com.example.medical.model.DoctorModel;
import com.example.medical.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorModel> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public DoctorModel getDoctor(String did) {
        return doctorRepository.findById(did).orElse(null);
    }


    public DoctorModel createDoctor(DoctorModel doctorModel) {
        return doctorRepository.save(doctorModel);
    }

    public void deleteDoctor(String did) {
        doctorRepository.deleteById(did);
    }

    public DoctorModel updateDoctor(DoctorModel doctorModel, String did) {
        DoctorModel doctorModel1 = doctorRepository.findById(did).get();
        doctorModel1.setdName(doctorModel.getdName());
        doctorModel1.setSpeciality(doctorModel.getSpeciality());
        doctorRepository.save(doctorModel1);
        return doctorModel1;
    }

    public void deleteAllDoctors() {
        doctorRepository.deleteAll();
    }
}
