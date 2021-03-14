package com.ana.PrivateInsurancePortfolio.model;

import javax.persistence.AttributeConverter;

public class PolicyTypeConverter implements AttributeConverter<PolicyType, String> {
    @Override
    public String convertToDatabaseColumn(PolicyType policyType) {
        switch (policyType){
            case TRAVEL:
                return "CA";
            case MOTOR_THIRD_PARTY_LIABILITY:
                return "MTPL";
            case MOTOR_OWN_DAMAGE:
                return "MOD";
            case ACCIDENT:
                return "NG";
            case PROPERTY_DAMAGE:
                return "PD";
            case GENERAL_LIABILITY:
                return "GL";
            case LIFE_INSURANCE:
                return "LIFE";
            default:throw new IllegalArgumentException("Unknown " + policyType);
        }
    }

    @Override
    public PolicyType convertToEntityAttribute(String s) {
        switch (s){
            case "CA":
                return PolicyType.TRAVEL;
            case "MTPL":
                return PolicyType.MOTOR_THIRD_PARTY_LIABILITY;
            case "MOD":
                return PolicyType.MOTOR_OWN_DAMAGE;
            case "NG":
                return PolicyType.ACCIDENT;
            case "PD":
                return PolicyType.PROPERTY_DAMAGE;
            case "GL":
                return PolicyType.GENERAL_LIABILITY;
            case "LIFE":
                return PolicyType.LIFE_INSURANCE;
            default: throw new IllegalArgumentException("Unknown policy type " + s);
        }
    }
}
