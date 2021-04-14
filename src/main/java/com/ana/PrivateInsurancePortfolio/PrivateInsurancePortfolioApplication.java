package com.ana.PrivateInsurancePortfolio;

import com.ana.PrivateInsurancePortfolio.model.*;
import com.ana.PrivateInsurancePortfolio.repositories.*;
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
										PersonRepository personRepository,
										VehicleRepository vehicleRepository,
										PropertyRepository propertyRepository,
										PolicyRepository policyRepository,
										InstallmentRepository installmentRepository){
		return args -> {
			SystemUser jake = new SystemUser(
					"Jake",
					"Brown",
					"jb",
					"pass",
					"test@test.com",
					"+37122222222", true);
			userRepository.save(jake);

			Person maria = new Person(
					"Maria",
					"Brown",
					"ID21934348987",
					jake);
			personRepository.save(maria);

			Person david = new Person(
					"David",
					"Brown",
					"ID219344444",
					jake);
			personRepository.save(david);

			jake.getRelatedPersons().add(maria);
			jake.getRelatedPersons().add(david);
			System.out.println(jake.getRelatedPersons().toString());

			Vehicle car = new Vehicle(VehicleType.CAR,
					"Bmw",
					"X6",
					2018,
					"AR7676",
					"AF7777777",
					maria);

			Vehicle tractor = new Vehicle(VehicleType.TRACTOR,
					"BELARUS",
					"111",
					1990,
					"T4566LV",
					"A879899",
					maria);

			vehicleRepository.save(car);
			vehicleRepository.save(tractor);

			maria.addVehicle(car);
			maria.addVehicle(tractor);

			System.out.println(maria.getVehicles().toString());

			Property testProperty = new Property(
					"some address",
					2015,
					150.5,
					1,
					david
			);

			propertyRepository.save(testProperty);

			david.addProperty(testProperty);
			System.out.println(david.getProperties().toString());

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
					david);

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

		};
	}
}
