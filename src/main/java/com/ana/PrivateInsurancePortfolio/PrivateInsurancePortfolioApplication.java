package com.ana.PrivateInsurancePortfolio;

import com.ana.PrivateInsurancePortfolio.model.*;
import com.ana.PrivateInsurancePortfolio.repositories.*;
import com.ana.PrivateInsurancePortfolio.service.VehicleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
										InstallmentRepository installmentRepository){
		return args -> {
			SystemUser jake = new SystemUser(
					"Jake",
					"Brown",
					"a",
					"a",
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
        	Date startDate = simpleDateFormat.parse("2020-5-20");
        	Date endDate = simpleDateFormat.parse("2021-05-19");
        	Date paymDate = simpleDateFormat.parse("2020-06-01");

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

			Installment firstPaym = new Installment(
					mtplPolicy,
					1,
					1,
					120.0,
					paymDate,
					PaymentStatus.UNPAID
			);

			installmentRepository.save(firstPaym);
			mtplPolicy.addInstallment(firstPaym);

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
