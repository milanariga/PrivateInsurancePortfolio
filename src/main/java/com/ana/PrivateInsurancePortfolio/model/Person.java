package com.ana.PrivateInsurancePortfolio.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Person")
@Table(
        name = "person"
)
public class Person {

    @Id
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
            name = "person_id",
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SystemUser relatedUser;

    @OneToMany
    @JoinColumn(name = "person_id")
    private Set<Vehicle> vehicles = new HashSet<>();

    public Person() {
    }

    public Person(String firstName, String lastName, String idCode,
                  //Set<Policy> policies,
                  SystemUser relatedUser
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCode = idCode;
        //this.policies = policies;
        this.relatedUser = relatedUser;
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

    public SystemUser getRelatedUser() {
        return relatedUser;
    }

    public void setRelatedUser(SystemUser relatedUser) {
        this.relatedUser = relatedUser;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idCode='" + idCode + '\'' +
                //", policies=" + policies +
                ", user=" + relatedUser +
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
