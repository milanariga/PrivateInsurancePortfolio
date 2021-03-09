package com.ana.PrivateInsurancePortfolio.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class VehicleTypeConverter implements AttributeConverter<VehicleType, String> {

    @Override
    public String convertToDatabaseColumn(VehicleType vehicleType) {
        switch (vehicleType){
            case CAR:
                return "C";
            case TRACTOR:
                return "T";
            case TRAILER:
                return "P";
            case MOTORCYCLE:
                return "M";
            default:throw new IllegalArgumentException("Unknown " + vehicleType);
        }
    }

    @Override
    public VehicleType convertToEntityAttribute(String s) {
        switch (s){
            case "C":
                return VehicleType.CAR;
            case "T":
                return VehicleType.TRACTOR;
            case "P":
                return VehicleType.TRAILER;
            case "M":
                return VehicleType.MOTORCYCLE;
            default:
                throw new IllegalArgumentException("Unknown " + s);
        }

    }
}
