package com.example.censusAppBackend.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String streetName;
    private String postalCode;
    private String cityName;
    private String stateName;
    private String countryName;

    public Address(String streetName, String postalCode, String cityName, String stateName, String countryName) {
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.cityName = cityName;
        this.stateName = stateName;
        this.countryName = countryName;
    }
}
