package com.example.medical.service;

import com.example.medical.model.DoctorModel;
import com.example.medical.model.PatientModel;
import com.example.medical.model.RoomModel;
import com.example.medical.repository.PatientRepository;
import com.example.medical.repository.RoomRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {


    private final PatientRepository patientRepository;
    private final RoomRepository roomRepository;


    public PatientService(PatientRepository patientRepository, RoomRepository roomRepository) {
        this.patientRepository = patientRepository;
        this.roomRepository = roomRepository;
    }

    public List<PatientModel> getAllPatients() {
        return patientRepository.findAll();
    }

    public PatientModel getPatient(String pid) {
        return patientRepository.findById(pid).orElse(null);
    }


    public PatientModel createPatient(PatientModel patientModel) {

        RoomModel roomModel = roomRepository.findByOccupancy("NO");
        roomModel.setOccupied("Yes");
        roomModel.setPid(patientModel.getPid());
        roomRepository.save(roomModel);
        return patientRepository.save(patientModel);
    }

    public void deletePatient(String pid) {
        patientRepository.deleteById(pid);
    }

    public PatientModel updatePatient(PatientModel patientModel, String pid) {
        PatientModel patientModel1 = patientRepository.findById(pid).get();
        patientModel1.setpName(patientModel.getpName());
        patientModel1.setDid(patientModel.getDid());
        patientRepository.save(patientModel1);
        return patientModel1;
    }
    public String getDidByPid(String pid){
        PatientModel patient = patientRepository.findByPid(pid);
        String did=patient.getDid();
        return did;
    }
    public String getRidByPid(String pid){
       RoomModel room= roomRepository.findByPid(pid);
      String rid= room.getRid();

        return rid;
    }
    public void deleteAllPatients() {
        patientRepository.deleteAll();
    }

}
