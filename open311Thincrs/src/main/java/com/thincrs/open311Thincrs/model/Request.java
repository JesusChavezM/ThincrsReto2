package com.thincrs.open311Thincrs.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Request {

    @Id
    @GeneratedValue
    private long id;


}
