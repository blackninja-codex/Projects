package com.example.medical.repository;


import com.example.medical.model.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorModel, String> {

}
