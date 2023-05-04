package com.example.medical.service;

import com.example.medical.model.RecordModel;
import com.example.medical.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {


    private final RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public List<RecordModel> getAllRecords() {
        return recordRepository.findAll();
    }

    public RecordModel getRecord(String pid) {
        return recordRepository.findById(pid).orElse(null);
    }


    public RecordModel createRecord(RecordModel recordModel) {
        return recordRepository.save(recordModel);
    }

    public void deleteRecord(String pid) {
        recordRepository.deleteById(pid);
    }

    public RecordModel updateRecord(RecordModel recordModel, String pid) {
        RecordModel recordModel1 = recordRepository.findById(pid).get();
        recordModel1.setDischargeDate(recordModel.getDischargeDate());
        recordModel1.setDid(recordModel.getDid());
        recordModel1.setAge(recordModel.getAge());
        recordModel1.setAdmissionDate(recordModel.getAdmissionDate());
        recordRepository.save(recordModel1);
        return recordModel1;
    }

    public void deleteAllRecords() {
        recordRepository.deleteAll();
    }

}
