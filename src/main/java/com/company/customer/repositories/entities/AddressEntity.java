package com.company.customer.repositories.entities;

import javax.persistence.*;

@Entity
@Table(name="address", schema = "fiap")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String state;
    private String city;
    private String zipCode;

    public AddressEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    private AddressEntity(Builder builder) {
        id = builder.id;
        state = builder.state;
        city = builder.city;
        zipCode = builder.zipCode;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(AddressEntity copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.state = copy.getState();
        builder.city = copy.getCity();
        builder.zipCode = copy.getZipCode();
        return builder;
    }


    public static final class Builder {
        private Long id;
        private String state;
        private String city;
        private String zipCode;

        private Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withState(String val) {
            state = val;
            return this;
        }

        public Builder withCity(String val) {
            city = val;
            return this;
        }

        public Builder withZipCode(String val) {
            zipCode = val;
            return this;
        }

        public AddressEntity build() {
            return new AddressEntity(this);
        }
    }
}
