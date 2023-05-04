package com.example.medical.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table 
public class PatientModel {
    @Id
    private String pid;
    @Column
    private String pName;
    @Column
    private String did;

    @Column
    private String phone;
    @Column
    private String diagnose;

    public PatientModel()
    {

    }

    public PatientModel(String pid, String pName, String did, String phone, String diagnose) {
        this.pid = pid;
        this.pName = pName;
        this.did = did;
        this.phone = phone;
        this.diagnose = diagnose;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }
}

