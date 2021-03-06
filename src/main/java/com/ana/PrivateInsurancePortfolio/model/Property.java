//package com.ana.PrivateInsurancePortfolio.model;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//public class Property {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long propertyId;
//    private String address;
//    private int constrYear;
//    private Double area;
//    private int numOfFloor;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    //@ManyToMany(mappedBy = "policyId")
//    //private Set<Policy> policies;
//
//    public Property() {
//    }
//
//    public Property(Long propertyId, String address, int constrYear, Double area, int numOfFloor, User user//, Set<Policy> policies
//                    ) {
//        this.propertyId = propertyId;
//        this.address = address;
//        this.constrYear = constrYear;
//        this.area = area;
//        this.numOfFloor = numOfFloor;
//        this.user = user;
//        //this.policies = policies;
//    }
//
//    public Long getPropertyId() {
//        return propertyId;
//    }
//
//    public void setPropertyId(Long propertyId) {
//        this.propertyId = propertyId;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public int getConstrYear() {
//        return constrYear;
//    }
//
//    public void setConstrYear(int constrYear) {
//        this.constrYear = constrYear;
//    }
//
//    public Double getArea() {
//        return area;
//    }
//
//    public void setArea(Double area) {
//        this.area = area;
//    }
//
//    public int getNumOfFloor() {
//        return numOfFloor;
//    }
//
//    public void setNumOfFloor(int numOfFloor) {
//        this.numOfFloor = numOfFloor;
//    }
//
////    public Set<Policy> getPolicies() {
////        return policies;
////    }
////
////    public void setPolicies(Set<Policy> policies) {
////        this.policies = policies;
////    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    @Override
//    public String toString() {
//        return "Property{" +
//                "propertyId=" + propertyId +
//                ", address='" + address + '\'' +
//                ", constrYear=" + constrYear +
//                ", area=" + area +
//                ", NumOfFloor=" + numOfFloor +
//                ", user=" + user +
//                //", policies=" + policies +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Property property = (Property) o;
//
//        return propertyId != null ? propertyId.equals(property.propertyId) : property.propertyId == null;
//    }
//
//    @Override
//    public int hashCode() {
//        return propertyId != null ? propertyId.hashCode() : 0;
//    }
//}
