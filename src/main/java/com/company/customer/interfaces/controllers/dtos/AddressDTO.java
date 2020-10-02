package com.company.customer.interfaces.controllers.dtos;

import java.io.Serializable;

public class AddressDTO implements Serializable {

    private Long id;
    private String state;
    private String city;
    private String zipCode;

    public AddressDTO(Long id, String state, String city, String zipCode) {
        this.id = id;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
    }

    public AddressDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
