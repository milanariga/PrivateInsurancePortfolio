package com.ana.PrivateInsurancePortfolio.model;

import com.ana.PrivateInsurancePortfolio.repositories.InstallmentRepository;

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

//    @ManyToMany
//    @JoinTable(name = "policy_objects", joinColumns = @JoinColumn(name = "policy_id"),
//                inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
//    private Set<Vehicle> insuredObjects = new HashSet<>(); //object IDs

    @Column(
            name = "start_date",
            nullable = false,
            columnDefinition = "DATE"
    )
    private Date startDate;

    @Column(
            name = "end_date",
            nullable = false,
            columnDefinition = "DATE"
    )
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

    @OneToMany
    @JoinColumn(
            name = "policy_id"
    )
    private Set<Installment> installments = new HashSet<>();

    @Convert(converter = PaymentStatusConverter.class)
    private PaymentStatus policyPaymentStatus;

    @Column(
            name = "sum_insured",
            columnDefinition = "NUMERIC(10,2)"
    )
    private Double sumInsured;

    @ManyToOne
    @JoinColumn(
            name = "policyholder",
            foreignKey = @ForeignKey(name = "FK_person_id")
    )
    private Person policyHolder;

    public Policy() {
    }

    public Policy(String number, PolicyType policyType, ObjectType objectType, PolicyStatus status,
                  Date startDate, Date endDate, Double premium,
                  int noOfInstallments,
                  PaymentStatus policyPaymentStatus,
                  Double sumInsured, Person policyHolder) {
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

//    public Set<Vehicle> getInsuredObjects() {
//        return insuredObjects;
//    }
//
//    public void setInsuredObjects(Set<Vehicle> insuredObjects) {
//        this.insuredObjects = insuredObjects;
//    }

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

    public Set<Installment> getInstallments() {
        return installments;
    }

    public void setInstallments(Set<Installment> installments) {
        //this.installments = getInstallments().addAll(installments);
        this.installments = installments;
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

    public void addInstallment(Installment installment){
        this.installments.add(installment);
        setPolicyPaymentStatus(installment.getPaymentStatus());
        System.out.println(installment.getPaymentStatus().toString());
        System.out.println(policyPaymentStatus.toString());
    }

    public Person getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(Person policyHolder) {
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
