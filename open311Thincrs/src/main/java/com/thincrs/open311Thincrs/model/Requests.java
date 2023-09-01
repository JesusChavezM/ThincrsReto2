package com.thincrs.open311Thincrs.model;


import jakarta.persistence.*;

@Entity
public class Requests {

    @Id
    @GeneratedValue
    private long id;
    private String date;
    private String status;
    private String details;
    private String locate;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services service;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }
}
