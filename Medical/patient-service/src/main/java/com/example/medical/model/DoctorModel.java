package com.example.medical.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class DoctorModel {
    @Id
    private String did;
    @Column
    private String dName;
    @Column
    private String speciality;
    public DoctorModel(){

    }
    public DoctorModel(String did, String dName, String speciality) {
        this.did = did;
        this.dName = dName;
        this.speciality = speciality;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

}
