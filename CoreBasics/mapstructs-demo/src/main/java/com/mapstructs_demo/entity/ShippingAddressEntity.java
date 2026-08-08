package com.mapstructs_demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shipping_addresses", schema = "basics")
public class ShippingAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "address_id")
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
    @ToString.Exclude
    private OrderEntity order;
}
