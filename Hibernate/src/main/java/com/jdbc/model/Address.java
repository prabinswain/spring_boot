package com.jdbc.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Embeddable
public class Address {

    private String houseNo;
    private String street;
    private String city;
    private String state;
    private Integer pin;

}
