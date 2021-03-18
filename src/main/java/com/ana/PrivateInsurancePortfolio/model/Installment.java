package com.ana.PrivateInsurancePortfolio.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "installments")
public class Installment {

    @Id
    @SequenceGenerator(
            name = "installments_sequence",
            sequenceName = "installments_sequence",
            allocationSize = 1,
            initialValue = 100
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "installments_sequence"
    )
    @Column(
            name = "installment_id",
            updatable = false
    )
    private Long installmentId;

    @ManyToOne
    @JoinColumn(
            name = "policy_id",
            foreignKey = @ForeignKey(name = "FK_policy")
    )
    private Policy policy;

    public int getInstallmentCount() {
        return installmentCount;
    }

    public void setInstallmentCount(int installmentCount) {
        this.installmentCount = installmentCount;
    }

    @Column(
            name = "installments_count",
            nullable = false,
            columnDefinition = ("SMALLINT")
    )
    private int installmentCount;

    @Column(
            name = "installment_no",
            nullable = false,
            columnDefinition = ("SMALLINT")
    )
    private int installmentNo;

    @Column(
            name = "amount",
            nullable = false,
            columnDefinition = "NUMERIC(6,2)"
    )
    private double amount;

    @Column(
            name = "paym_due_date",
            nullable = false,
            columnDefinition = "DATE"
    )
    private Date paymentDueDate;

    @Convert(converter = PaymentStatusConverter.class)
    private PaymentStatus paymentStatus;

    public Installment() {
    }

    public Installment(
            Policy policy,
                       int installmentCount, int installmentNo, double amount, Date paymentDueDate, PaymentStatus paymentStatus) {
        this.policy = policy;
        this.installmentCount = installmentCount;
        this.installmentNo = installmentNo;
        this.amount = amount;
        this.paymentDueDate = paymentDueDate;
        this.paymentStatus = paymentStatus;
    }

    public Long getInstallmentId() {
        return installmentId;
    }

    public void setInstallmentId(Long installmentId) {
        this.installmentId = installmentId;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public int getInstallmentNo() {
        return installmentNo;
    }

    public void setInstallmentNo(int installmentNo) {
        this.installmentNo = installmentNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(Date paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Installment{" +
                "installmentId=" + installmentId +
                //", policy=" + policy +
                ", installmentNo=" + installmentNo +
                ", amount=" + amount +
                ", paymentDueDate=" + paymentDueDate +
                ", paymentStatus=" + paymentStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Installment that = (Installment) o;

        return installmentId != null ? installmentId.equals(that.installmentId) : that.installmentId == null;
    }

    @Override
    public int hashCode() {
        return installmentId != null ? installmentId.hashCode() : 0;
    }
}
