package com.ana.PrivateInsurancePortfolio.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "policy")
public class Policy {

    @Id
    @SequenceGenerator(
            name = "policy_sequence",
            sequenceName = "policy_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "policy_sequence"
    )
    @Column(
            name = "policy_id",
            updatable = false
    )
    private long policyId;

    @Column(
            name = "policy_number",
            nullable = false,
            columnDefinition = "VARCHAR(30)"
    )
    private String number;

    @Convert(converter = PolicyTypeConverter.class)
    private PolicyType policyType;

    @Convert(converter = ObjectTypeConverter.class)
    private ObjectType objectType;

    @Convert(converter = PolicyStatusConverter.class)
    private PolicyStatus status;

    @ManyToMany
    @JoinTable(name = "policy_vehicles", joinColumns = @JoinColumn(name = "policy_id"),
                inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    private Set<Vehicle> insuredVehicles = new HashSet<>(); //object IDs

    @ManyToMany
    @JoinTable(name = "policy_properties", joinColumns = @JoinColumn(name = "policy_id"),
            inverseJoinColumns = @JoinColumn(name = "property_id"))
    private Set<Property> insuredProperties = new HashSet<>(); //object IDs

    @Column(
            name = "start_date",
            nullable = false,
            columnDefinition = "DATE"
    )
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    @Column(
            name = "end_date",
            nullable = false,
            columnDefinition = "DATE"
    )
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    @Column(
            name = "premium",
            nullable = false,
            columnDefinition = "NUMERIC(6,2)"
    )
    private Double premium;

    @Column(
            name = "installments_count",
            nullable = false,
            columnDefinition = ("SMALLINT")
    )
    private int noOfInstallments;

    @Convert(converter = PaymentStatusConverter.class)
    private PaymentStatus policyPaymentStatus;

    @Column(
            name = "sum_insured",
            columnDefinition = "NUMERIC(10,2)"
    )
    private Double sumInsured;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "FK_user_id")
    )
    private SystemUser policyHolder;

    public Policy() {
    }

    public Policy(String number, PolicyType policyType, ObjectType objectType, PolicyStatus status,
                  Date startDate, Date endDate, Double premium,
                  int noOfInstallments,
                  PaymentStatus policyPaymentStatus,
                  Double sumInsured, SystemUser policyHolder) {
        this.number = number;
        this.policyType = policyType;
        this.objectType = objectType;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.premium = premium;
        this.noOfInstallments = noOfInstallments;
        this.policyPaymentStatus = policyPaymentStatus;
        this.sumInsured = sumInsured;
        this.policyHolder = policyHolder;
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

//    public String getPolicyType() {
//        switch (policyType) {
//            case MOTOR_THIRD_PARTY_LIABILITY:
//                return "MTPL";
//            case GENERAL_LIABILITY:
//                return "General Liability";
//            case PROPERTY_DAMAGE:
//                return "Property Insurance";
//            case ACCIDENT:
//                return "Accident Insurance";
//            case MOTOR_OWN_DAMAGE:
//                return "CASCO";
//            case TRAVEL:
//                return "Travel Insurance";
//            case LIFE_INSURANCE:
//                return "Life Insurance";
//            default: return "Unknown Policy Type";
//        }
//    }

    public PolicyType getPolicyType(){
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

    public Set<Vehicle> getInsuredVehicles() {
        return insuredVehicles;
    }

    public void setInsuredVehicles(Vehicle insuredVehicle) {
        getInsuredVehicles().add(insuredVehicle);
    }

    public Set<Property> getInsuredProperties() {
        return insuredProperties;
    }

    public void setInsuredProperties(Property insuredProperty) {
        getInsuredProperties().add(insuredProperty);
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

    public Double getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(Double sumInsured) {
        this.sumInsured = sumInsured;
    }

    public PaymentStatus getPolicyPaymentStatus() {
//        PaymentStatus policyPaymentStatus = PaymentStatus.UNAVAILABLE;
//        if (this.noOfInstallments == 1){
//            policyPaymentStatus  = installments.stream().findFirst().get().getPaymentStatus();
//            setPolicyPaymentStatus(policyPaymentStatus);
//        } else {
//            //TODO
//        }
        return policyPaymentStatus;
    }

    public void setPolicyPaymentStatus(PaymentStatus policyPaymentStatus) {
        this.policyPaymentStatus = policyPaymentStatus;
    }

    public SystemUser getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(SystemUser policyHolder) {
        this.policyHolder = policyHolder;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyId=" + policyId +
                ", number='" + number + '\'' +
                ", policyType=" + policyType +
                ", objectType=" + objectType +
                ", status=" + status +
                //", insuredObjects=" + insuredObjects +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", premium=" + premium +
                ", noOfInstallments=" + noOfInstallments +
                //", installment=" + installments +
                //", paymentStatus=" + paymentStatus +
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
