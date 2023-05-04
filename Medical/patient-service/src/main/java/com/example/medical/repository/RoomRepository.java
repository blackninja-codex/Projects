package com.example.medical.repository;


import com.example.medical.model.PatientModel;
import com.example.medical.model.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public interface RoomRepository extends JpaRepository<RoomModel, String> {


    @Query(value = "SELECT r.rid,r.occupied,r.pid from Room_Model r where r.occupied =:occupied limit 1  ", nativeQuery = true)
    RoomModel findByOccupancy(@Param("occupied") String occupied);

    @Query(value = "SELECT * from room_model r where r.pid =:pid limit 1  ", nativeQuery = true)
    RoomModel findByPid(@Param("pid") String pid);

}
