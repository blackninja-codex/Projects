package com.example.medical.repository;


import com.example.medical.model.RecordModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<RecordModel, String> {
}
