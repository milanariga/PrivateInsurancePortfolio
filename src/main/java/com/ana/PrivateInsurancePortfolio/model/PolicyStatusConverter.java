package com.ana.PrivateInsurancePortfolio.model;

import javax.persistence.AttributeConverter;

public class PolicyStatusConverter implements AttributeConverter<PolicyStatus, String> {
    @Override
    public String convertToDatabaseColumn(PolicyStatus policyStatus) {
        switch (policyStatus){
            case ACTIVE:
                return "A";
            case ENDING:
                return "E";
            case EXPIRED:
                return "O";
            case REJECTED:
                return "R";
            default:throw new IllegalArgumentException("Unknown policy status " + policyStatus);
        }
    }

    @Override
    public PolicyStatus convertToEntityAttribute(String s) {
        switch (s){
            case "A":
                return PolicyStatus.ACTIVE;
            case "E":
                return PolicyStatus.ENDING;
            case "O":
                return PolicyStatus.EXPIRED;
            case "R":
                return PolicyStatus.REJECTED;
            default:throw new IllegalArgumentException("Unknown policy status " + s);
        }
    }
}
