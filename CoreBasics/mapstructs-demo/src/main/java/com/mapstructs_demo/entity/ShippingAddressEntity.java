package com.mapstructs_demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddress {

    @Id
    @Column(name = "address_id", length = 36)
    private String addressId;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "city", length = 100, nullable = false)
    private String city;

    @Column(name = "state", length = 100, nullable = false)
    private String state;

    @Column(name = "zip_code", length = 20, nullable = false)
    private String zipCode;

    @Column(name = "country", length = 100, nullable = false)
    private String country;

    @OneToOne(mappedBy = "shippingAddress")
    private OrderEntity order;
}
