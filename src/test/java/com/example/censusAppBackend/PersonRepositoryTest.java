package com.example.censusAppBackend;

import com.example.censusAppBackend.model.Address;
import com.example.censusAppBackend.model.Employment;
import com.example.censusAppBackend.model.Person;
import com.example.censusAppBackend.model.UserRole;
import com.example.censusAppBackend.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class PersonRepositoryTest {
    @Autowired
    private PersonRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreatePerson(){
        Person person = new Person();
        Address address = new Address();
        Employment employment = new Employment();
        //Address
        address.setCountryName("Sweden");
        address.setCityName("Malmö");
        address.setStateName("Skåen");
        address.setPostalCode("256788");
        address.setStreetName("slåttervägen 120");

        // Employment
        employment.setEmployed(true);
        employment.setOrganizationName("IKA");
        employment.setStateName("Skåne");
        employment.setCountryName("Sweden");
        employment.setCityName("malmö");

        person.setFirstName("Tahir");
        person.setMiddleName("abbe");
        person.setLastName("Raki");
        person.setGender("Male");
        person.setCitizenship("Swidish");
        person.setDataOfBirth("2020-01-01");
        person.setCountryOfBirth("Sweden");
        person.setPlaceOfBirth("Kristianstad");
        person.setMaritalStatus("Single");
        person.setEmail("rihat@gmail.com");
        person.setPassword("asdfsdfsf");
        person.setMobileNumber("97987497997977");
        person.setAddress(address);
        person.setEmployment(employment);
        person.setUserRole(UserRole.USER);

       Person savedPerson =repo.save(person);
       Person existPerson = entityManager.find(Person.class,savedPerson.getId());
        assertThat(existPerson.getEmail()).isEqualTo(savedPerson.getEmail());
    }
}
