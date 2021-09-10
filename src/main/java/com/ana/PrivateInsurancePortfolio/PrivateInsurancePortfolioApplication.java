package com.ana.PrivateInsurancePortfolio;

import com.ana.PrivateInsurancePortfolio.model.*;
import com.ana.PrivateInsurancePortfolio.repositories.*;
import com.ana.PrivateInsurancePortfolio.service.VehicleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class PrivateInsurancePortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrivateInsurancePortfolioApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository,
										VehicleService vehicleService,
										PropertyRepository propertyRepository,
										PolicyRepository policyRepository,
										BCryptPasswordEncoder bCryptPasswordEncoder){
		return args -> {
			String encodedPass = bCryptPasswordEncoder.encode("a");
			SystemUser jake = new SystemUser(
					"Jake",
					"Brown",
					"aa",
					encodedPass,
					"test@test.com",
					"+37122222222", true);
			userRepository.save(jake);

			Vehicle car = new Vehicle(VehicleType.CAR,
					"Bmw",
					"X6",
					2018,
					"AR7676",
					"AF7777777",
					jake);

			Vehicle tractor = new Vehicle(VehicleType.TRACTOR,
					"BELARUS",
					"111",
					1990,
					"T4566LV",
					"A879899",
					jake);
			//tractor.setActive(false);

			vehicleService.saveVehicle(car);
			vehicleService.saveVehicle(tractor);

			jake.addVehicle(car);
			jake.addVehicle(tractor);

			String encodedPass2 = bCryptPasswordEncoder.encode("s");
			SystemUser mad = new SystemUser(
					"Mady",
					"Lake",
					"ss",
					encodedPass2,
					"mady@test.com",
					"+37155555555", true);
			userRepository.save(mad);

			Vehicle mady_car = new Vehicle(VehicleType.CAR,
					"Audi",
					"X2",
					2020,
					"MADY",
					"AF1111111",
					mad);

			Vehicle mady_moto = new Vehicle(VehicleType.MOTORCYCLE,
					"Harley",
					"Davidson",
					2001,
					"T111XX",
					"A232432",
					mad);
			//tractor.setActive(false);

			vehicleService.saveVehicle(mady_car);
			vehicleService.saveVehicle(mady_moto);

			jake.addVehicle(mady_car);
			jake.addVehicle(mady_moto);

			Property testProperty = new Property(
					"Unknown Str. 25",
					2015,
					150.5,
					1,
					jake
			);

			propertyRepository.save(testProperty);

			jake.addProperty(testProperty);

			String pattern = "yyyy-MM-dd";
        	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        	Date startDate = simpleDateFormat.parse("2020-09-20");
        	Date endDate = simpleDateFormat.parse("2021-09-19");
        	Date paymDate = simpleDateFormat.parse("2020-10-01");

			Policy mtplPolicy = new Policy(
					"SDA1234",
					PolicyType.MOTOR_THIRD_PARTY_LIABILITY,
					ObjectType.VEHICLE,
					PolicyStatus.ACTIVE,
					startDate,
					endDate,
					120.0,
					1,
					PaymentStatus.UNAVAILABLE,
					1000000.0,
					jake);

			mtplPolicy.setInsuredVehicles(car);
			mtplPolicy.setInsuredVehicles(tractor);
			policyRepository.save(mtplPolicy);

			Policy pdPolicy = new Policy(
					"PD1111",
					PolicyType.PROPERTY_DAMAGE,
					ObjectType.PROPERTY,
					PolicyStatus.ACTIVE,
					startDate,
					endDate,
					200.00,
					2,
					PaymentStatus.UNAVAILABLE,
					200000.00,
					jake
			);

			pdPolicy.setInsuredProperties(testProperty);
			policyRepository.save(pdPolicy);

		};
	}
}
