package com.ana.PrivateInsurancePortfolio.model;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Person")
public class Person {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )
    @Column (
            name = "id",
            updatable = false
    )
    private Long personId;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "VARCHAR(50)"
    )
    private String firstName;
    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "VARCHAR(100)"
    )
    private String lastName;
    @Column(
            name = "id_code",
            nullable = false,
            columnDefinition = "VARCHAR(20)"
    )
    private String idCode;

    //@ManyToMany(mappedBy = "policyId")
    //private Set<Policy> policies;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    public Person() {
    }

    public Person(Long personId, String firstName, String lastName, String idCode
            //,
                  //Set<Policy> policies,
                  //User user
    ) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCode = idCode;
        //this.policies = policies;
        //this.user = user;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

//    public Set<Policy> getPolicies() {
//        return policies;
//    }
//
//    public void setPolicies(Set<Policy> policies) {
//        this.policies = policies;
//    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idCode='" + idCode + '\'' +
                //", policies=" + policies +
                //", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return personId != null ? personId.equals(person.personId) : person.personId == null;
    }

    @Override
    public int hashCode() {
        return personId != null ? personId.hashCode() : 0;
    }
}
