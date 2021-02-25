package com.example.censusAppBackend.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Person implements UserDetails {

    @SequenceGenerator(
            name="citizen_sequence",
            sequenceName = "citizen_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "citizen_sequence")
    @Id
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String citizenship;
    private String dataOfBirth;
    private String countryOfBirth;
    private String placeOfBirth;
    private String maritalStatus;
    @Column(nullable = false,unique = true,length = 45)
    private String email;
    @Column(nullable = false,unique = true,length = 64)
    private String password;
    private String mobileNumber;
    @OneToOne(targetEntity = Address.class,cascade =CascadeType.ALL)
    private Address address;
    @OneToOne(targetEntity = Employment.class,cascade =CascadeType.ALL)
    private Employment employment;
    private UserRole userRole;

    public Person(String firstName,
                  String middleName,
                  String lastName,
                  String gender,
                  String citizenship,
                  String dataOfBirth,
                  String countryOfBirth,
                  String placeOfBirth,
                  String maritalStatus,
                  String email,
                  String password,
                  String mobileNumber,
                  Address address,
                  Employment employment,
                  UserRole userRole) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.citizenship = citizenship;
        this.dataOfBirth = dataOfBirth;
        this.countryOfBirth = countryOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.maritalStatus = maritalStatus;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.employment = employment;
        this.userRole = userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
