package com.example.medical.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table 
public class RecordModel {
    @Id
    private String pid;
    @Column
    private String dischargeDate;
    @Column
    private String did;
    @Column
    private String admissionDate;
    @Column
    private String diagnose;
    @Column
    private String age;

    public RecordModel()
    {

    }

    public RecordModel(String pid, String dischargeDate, String did, String admissionDate, String diagnose, String age) {
        this.pid = pid;
        this.dischargeDate = dischargeDate;
        this.did = did;
        this.admissionDate = admissionDate;
        this.diagnose = diagnose;
        this.age = age;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}

