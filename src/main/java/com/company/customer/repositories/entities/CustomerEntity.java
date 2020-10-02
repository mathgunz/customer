package com.company.customer.repositories.entities;

import javax.persistence.*;

@Entity
@Table(name="customer", schema = "fiap")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String document;

    @OneToOne(cascade = CascadeType.ALL)
    private AddressEntity addressEntity;

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

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public CustomerEntity(){}

    private CustomerEntity(Builder builder) {
        id = builder.id;
        name = builder.name;
        lastName = builder.lastName;
        document = builder.document;
        addressEntity = builder.addressEntity;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(CustomerEntity copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.name = copy.getName();
        builder.lastName = copy.getLastName();
        builder.document = copy.getDocument();
        builder.addressEntity = copy.getAddressEntity();
        return builder;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String lastName;
        private String document;
        private AddressEntity addressEntity;

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

        public Builder withAddressEntity(AddressEntity val) {
            addressEntity = val;
            return this;
        }

        public CustomerEntity build() {
            return new CustomerEntity(this);
        }
    }
}
