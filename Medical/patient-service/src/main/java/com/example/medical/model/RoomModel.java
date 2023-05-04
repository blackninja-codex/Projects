package com.example.medical.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class RoomModel {
    @Id
    private String rid;
    @Column
    private String pid;
    @Column
    private String occupied;

    public RoomModel(){

    }

    public RoomModel(String rid, String pid, String occupied) {
        this.rid = rid;
        this.pid = pid;
        this.occupied = occupied;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getOccupied() {
        return occupied;
    }

    public void setOccupied(String occupied) {
        this.occupied = occupied;
    }
}

