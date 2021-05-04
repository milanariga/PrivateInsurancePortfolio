package com.ana.PrivateInsurancePortfolio.model;

import javax.persistence.AttributeConverter;

public class ObjectTypeConverter implements AttributeConverter<ObjectType, String> {
    @Override
    public String convertToDatabaseColumn(ObjectType objectType) {
        switch (objectType){
            case VEHICLE:
                return "V";
            case PROPERTY:
                return "H";
            default:throw new IllegalArgumentException("Unknown object " + objectType);
        }
    }

    @Override
    public ObjectType convertToEntityAttribute(String s) {
        switch (s){
            case "V":
                return ObjectType.VEHICLE;
            case "H":
                return ObjectType.PROPERTY;
            default: throw new IllegalArgumentException("Unknown object " + s);
        }
    }
}
