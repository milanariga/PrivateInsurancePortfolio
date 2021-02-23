package com.ana.PrivateInsurancePortfolio.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "policy_id")
    private long policyId;

    private String number;
    private PolicyType policyType;
    private ObjectType objectType;
    private PolicyStatus status;
    @ManyToMany
    @JoinTable(name = "policy_objects", joinColumns = @JoinColumn(name = "policy_id"),
                inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    private Set<Vehicle> insuredObjects = new HashSet<>(); //object IDs
    private Date startDate;
    private Date endDate;
    private Double premium;
    private int noOfInstallments;

    @OneToMany
    @JoinColumn(name = "installment_id")
    private List<Installment> installment;
    private PaymentStatus paymentStatus;
    private Double sumInsured;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Policy() {
    }

    public Policy(String number, PolicyType policyType, ObjectType objectType, PolicyStatus status,
                  Date startDate, Date endDate, Double premium,
                  int noOfInstallments, PaymentStatus paymentStatus, Double sumInsured, User user) {
        this.number = number;
        this.policyType = policyType;
        this.objectType = objectType;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.premium = premium;
        this.noOfInstallments = noOfInstallments;
        this.paymentStatus = paymentStatus;
        this.sumInsured = sumInsured;
        this.user = user;
    }

    public long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(long policyId) {
        this.policyId = policyId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PolicyType getPolicyType() {
        return policyType;
    }

    public void setPolicyType(PolicyType policyType) {
        this.policyType = policyType;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public PolicyStatus getStatus() {
        return status;
    }

    public void setStatus(PolicyStatus status) {
        this.status = status;
    }

    public Set<Vehicle> getInsuredObjects() {
        return insuredObjects;
    }

    public void setInsuredObjects(Set<Vehicle> insuredObjects) {
        this.insuredObjects = insuredObjects;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public int getNoOfInstallments() {
        return noOfInstallments;
    }

    public void setNoOfInstallments(int noOfInstallments) {
        this.noOfInstallments = noOfInstallments;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Double getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(Double sumInsured) {
        this.sumInsured = sumInsured;
    }

    public List<Installment> getInstallment() {
        return installment;
    }

    public void setInstallment(List<Installment> installment) {
        this.installment = installment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyId=" + policyId +
                ", number='" + number + '\'' +
                ", policyType=" + policyType +
                ", objectType=" + objectType +
                ", status=" + status +
                ", insuredObjects=" + insuredObjects +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", premium=" + premium +
                ", noOfInstallments=" + noOfInstallments +
                ", installment=" + installment +
                ", paymentStatus=" + paymentStatus +
                ", sumInsured=" + sumInsured +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Policy policy = (Policy) o;

        return policyId == policy.policyId;
    }

    @Override
    public int hashCode() {
        return (int) (policyId ^ (policyId >>> 32));
    }
}
