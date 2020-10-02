package com.company.customer.interfaces.controllers.dtos;

public class CustomerDTO {

    private Long id;
    private String name;
    private String lastName;
    private String document;

    private CustomerDTO(Builder builder) {
        id = builder.id;
        name = builder.name;
        lastName = builder.lastName;
        document = builder.document;
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
        return builder;
    }

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

    public static final class Builder {
        private Long id;
        private String name;
        private String lastName;
        private String document;

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

        public CustomerDTO build() {
            return new CustomerDTO(this);
        }
    }
}
