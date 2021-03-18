package com.ana.PrivateInsurancePortfolio.model;

import javax.persistence.AttributeConverter;

public class PaymentStatusConverter implements AttributeConverter<PaymentStatus, String> {
    @Override
    public String convertToDatabaseColumn(PaymentStatus paymentStatus) {

        switch (paymentStatus){
            case PAID:
                return "PAID";
            case UNPAID:
                return "UNP";
            case OVERDUE:
                return "LATE";
            case PARTIALLY_PAID:
                return "PART";
            case UNAVAILABLE:
                return "NA";
            default:throw new IllegalArgumentException("Unknown payment status " + paymentStatus);
        }
    }

    @Override
    public PaymentStatus convertToEntityAttribute(String s) {
        switch (s){
            case "PAID":
                return PaymentStatus.PAID;
            case "UNP":
                return PaymentStatus.UNPAID;
            case "LATE":
                return PaymentStatus.OVERDUE;
            case "PART":
                return PaymentStatus.PARTIALLY_PAID;
            case "NA":
                return PaymentStatus.UNAVAILABLE;
            default:throw new IllegalArgumentException("Unknown status " + s);
        }
    }
}
