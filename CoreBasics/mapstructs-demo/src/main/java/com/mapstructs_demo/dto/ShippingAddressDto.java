package com.mapstructs_demo.dto;

import lombok.Data;

@Data
public class ShippingAddressDto {

    private String addressId;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}
