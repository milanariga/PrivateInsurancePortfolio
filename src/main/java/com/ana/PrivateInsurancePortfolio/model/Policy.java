package com.ana.PrivateInsurancePortfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Set;

@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String number;
    private PolicyType policyType;
    private ObjectType objectType;
    private PolicyStatus status;
    private Set<?> insuredObjects; //object IDs
    private Date startDate;
    private Date endDate;
    private Double premium;
    private int numberOfPayments;
    private PaymentStatus paymentStatus;
    private Double sumInsured;

    public Policy() {
    }

    public Policy(long id, String number, PolicyType policyType, ObjectType objectType, PolicyStatus status, Set<?> insuredObjects, Date startDate, Date endDate, Double premium, int numberOfPayments, PaymentStatus paymentStatus, Double sumInsured) {
        this.id = id;
        this.number = number;
        this.policyType = policyType;
        this.objectType = objectType;
        this.status = status;
        this.insuredObjects = insuredObjects;
        this.startDate = startDate;
        this.endDate = endDate;
        this.premium = premium;
        this.numberOfPayments = numberOfPayments;
        this.paymentStatus = paymentStatus;
        this.sumInsured = sumInsured;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<?> getInsuredObjects() {
        return insuredObjects;
    }

    public void setInsuredObjects(Set<?> insuredObjects) {
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

    public int getNumberOfPayments() {
        return numberOfPayments;
    }

    public void setNumberOfPayments(int numberOfPayments) {
        this.numberOfPayments = numberOfPayments;
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
}
