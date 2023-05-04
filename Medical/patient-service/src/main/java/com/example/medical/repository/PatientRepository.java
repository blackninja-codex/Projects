package com.example.medical.repository;


import com.example.medical.model.PatientModel;
import com.example.medical.model.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientModel, String> {

    @Query(value = "SELECT * from patient_model r where r.pid =:pid limit 1  ", nativeQuery = true)
    PatientModel findByPid(@Param("pid") String pid);
}
