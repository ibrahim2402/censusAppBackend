package com.example.censusAppBackend.model;

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
public class Employment {
    @Id
    @GeneratedValue
    private Long id;
    private boolean employed;
    private  String organizationName;
    private  String stateName;
    private  String cityName;
    private  String countryName;

    public Employment(boolean employed, String organizationName, String stateName, String cityName, String countryName) {
        this.employed = employed;
        this.organizationName = organizationName;
        this.stateName = stateName;
        this.cityName = cityName;
        this.countryName = countryName;
    }
}
