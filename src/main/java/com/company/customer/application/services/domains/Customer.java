package com.company.customer.application.services.domains;

import java.io.Serializable;

public class Customer implements Serializable {

    public static final String CACHE_NAME = "Customer";
    private Long id;
    private String name;
    private String lastName;
    private String document;
    private Address address;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public Address getAddress() {
        return address;
    }

    private Customer(Builder builder) {
        id = builder.id;
        name = builder.name;
        lastName = builder.lastName;
        document = builder.document;
        address = builder.address;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Customer copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.name = copy.getName();
        builder.lastName = copy.getLastName();
        builder.document = copy.getDocument();
        builder.address = copy.getAddress();
        return builder;
    }


    public static final class Builder {
        private Long id;
        private String name;
        private String lastName;
        private String document;
        private Address address;

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

        public Builder withAddress(Address val) {
            address = val;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
