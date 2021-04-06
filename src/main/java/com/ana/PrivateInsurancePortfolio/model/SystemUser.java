package com.ana.PrivateInsurancePortfolio.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "SystemUser")
@Table(
        name = "system_user",
        uniqueConstraints = {
                @UniqueConstraint(name = "username_unique", columnNames = "username")
        }
)
public class SystemUser {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",

            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column (
            name = "user_id",
            updatable = false,
            insertable = false
    )
    private Long userId;

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
            name = "username",
            nullable = false,
            columnDefinition = "VARCHAR(100)"
    )
    private String username;
    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "VARCHAR(100)"
    )
    private String password;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "VARCHAR(100)"
    )
    private String email;
    @Column(
            name = "mobile",
            columnDefinition = "VARCHAR(100)"
    )
    private String mobile;
//    @OneToMany(mappedBy = "user")
//    private Set<Policy> policies;
//
//    @OneToMany(mappedBy = "user")
//    private Set<Property> property;
//
//    @OneToMany(mappedBy = "user")
//    private Set<Vehicle> vehicles;

    @Column(
            name = "related_persons"
    )
    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<Person> relatedPersons = new HashSet<>();

    @Column(
            name = "active",
            nullable = false,
            columnDefinition = "BOOLEAN"
    )
    private boolean active;

    public SystemUser() {

    }

    public SystemUser(String firstName, String lastName, String username, String password, String email, String mobile, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.active = active;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    //    public Set<Policy> getPolicies() {
//        return policies;
//    }
//
//    public void setPolicies(Set<Policy> policies) {
//        this.policies = policies;
//    }
//
//    public Set<Property> getProperty() {
//        return property;
//    }
//
//    public void setProperty(Set<Property> property) {
//        this.property = property;
//    }
//
//    public Set<Vehicle> getVehicles() {
//        return vehicles;
//    }
//
//    public void setVehicles(Set<Vehicle> vehicles) {
//        this.vehicles = vehicles;
//    }

    public Set<Person> getRelatedPersons() {
        return relatedPersons;
    }

    public void setRelatedPersons(Set<Person> relatedPersons) {
        this.relatedPersons = relatedPersons;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
//                ", policies=" + policies +
//                ", property=" + property +
//                ", vehicles=" + vehicles +
                //", persons=" + persons +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SystemUser systemUser = (SystemUser) o;

        return userId != null ? userId.equals(systemUser.userId) : systemUser.userId == null;
    }

    @Override
    public int hashCode() {
        return userId != null ? userId.hashCode() : 0;
    }
}
