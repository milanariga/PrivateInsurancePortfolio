//package com.ana.PrivateInsurancePortfolio.model;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//public class Installment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "installment_id")
//    private Long installmentId;
//
//    @ManyToOne
//    @JoinColumn(name = "policyId")
//    private Policy policy;
//    private int installmentNo;
//    private double amount;
//    private Date paymentDueDate;
//    private PaymentStatus paymentStatus;
//
//    public Installment() {
//    }
//
//    public Installment(Long installmentId, Policy policy, int installmentNo, double amount, Date paymentDueDate, PaymentStatus paymentStatus) {
//        this.installmentId = installmentId;
//        this.policy = policy;
//        this.installmentNo = installmentNo;
//        this.amount = amount;
//        this.paymentDueDate = paymentDueDate;
//        this.paymentStatus = paymentStatus;
//    }
//
//    public Long getInstallmentId() {
//        return installmentId;
//    }
//
//    public void setInstallmentId(Long installmentId) {
//        this.installmentId = installmentId;
//    }
//
//    public Policy getPolicy() {
//        return policy;
//    }
//
//    public void setPolicy(Policy policy) {
//        this.policy = policy;
//    }
//
//    public int getInstallmentNo() {
//        return installmentNo;
//    }
//
//    public void setInstallmentNo(int installmentNo) {
//        this.installmentNo = installmentNo;
//    }
//
//    public double getAmount() {
//        return amount;
//    }
//
//    public void setAmount(double amount) {
//        this.amount = amount;
//    }
//
//    public Date getPaymentDueDate() {
//        return paymentDueDate;
//    }
//
//    public void setPaymentDueDate(Date paymentDueDate) {
//        this.paymentDueDate = paymentDueDate;
//    }
//
//    public PaymentStatus getPaymentStatus() {
//        return paymentStatus;
//    }
//
//    public void setPaymentStatus(PaymentStatus paymentStatus) {
//        this.paymentStatus = paymentStatus;
//    }
//
//    @Override
//    public String toString() {
//        return "Installment{" +
//                "installmentId=" + installmentId +
//                ", policy=" + policy +
//                ", installmentNo=" + installmentNo +
//                ", amount=" + amount +
//                ", paymentDueDate=" + paymentDueDate +
//                ", paymentStatus=" + paymentStatus +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Installment that = (Installment) o;
//
//        return installmentId != null ? installmentId.equals(that.installmentId) : that.installmentId == null;
//    }
//
//    @Override
//    public int hashCode() {
//        return installmentId != null ? installmentId.hashCode() : 0;
//    }
//}
