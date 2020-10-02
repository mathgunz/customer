package com.company.customer.interfaces.controllers.dtos;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    private Long id;
    private String name;
    private String lastName;
    private String document;
    private AddressDTO address;

    public CustomerDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private CustomerDTO(Builder builder) {
        id = builder.id;
        name = builder.name;
        lastName = builder.lastName;
        document = builder.document;
        address = builder.addressDTO;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(CustomerDTO copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.name = copy.getName();
        builder.lastName = copy.getLastName();
        builder.document = copy.getDocument();
        builder.addressDTO = copy.getAddress();
        return builder;
    }


    public static final class Builder {
        private Long id;
        private String name;
        private String lastName;
        private String document;
        private AddressDTO addressDTO;

        private Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withLastName(String val) {
            lastName = val;
            return this;
        }

        public Builder withDocument(String val) {
            document = val;
            return this;
        }

        public Builder withAddressDTO(AddressDTO val) {
            addressDTO = val;
            return this;
        }

        public CustomerDTO build() {
            return new CustomerDTO(this);
        }
    }
}
