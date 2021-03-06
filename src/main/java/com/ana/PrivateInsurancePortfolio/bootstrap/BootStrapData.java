//package com.ana.PrivateInsurancePortfolio.bootstrap;
//
//import com.ana.PrivateInsurancePortfolio.model.*;
//import com.ana.PrivateInsurancePortfolio.repositories.*;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//public class BootStrapData implements CommandLineRunner {
//
//    //private final InstallmentRepository installmentRepository;
//    //private final PersonRepository personRepository;
//    private final PolicyRepository policyRepository;
//    //private final PropertyRepository propertyRepository;
//    private final UserRepository userRepository;
//    private final VehicleRepository vehicleRepository;
//
//    public BootStrapData(
//            //InstallmentRepository installmentRepository,
//            PolicyRepository policyRepository, UserRepository userRepository, VehicleRepository vehicleRepository) {
//        //this.installmentRepository = installmentRepository;
//        this.policyRepository = policyRepository;
//        this.userRepository = userRepository;
//        this.vehicleRepository = vehicleRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        User mainUser = new User("John", "Doe", "john.doe", "12345", "john@gmail.com", "22222222");
//        Vehicle toyotaCar = new Vehicle(VehicleType.CAR, "TOYOTA", "RAV4", 2019, "MD3267", "AF111111", mainUser);
//        String pattern = "yyyy-MM-dd";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        Date startDate = simpleDateFormat.parse("2020-5-20");
//        Date endDate = simpleDateFormat.parse("2021-05-19");
//        //Date startDate = new Date(2020, 4, 20);
//        //Date endDate = new Date(2021, 4, 19);
//
//
//        Policy policyOne = new Policy("MD123", PolicyType.MTPL, ObjectType.VEHICLE,
//                PolicyStatus.ACTIVE, startDate,endDate,
//                120.00, 1, PaymentStatus.PAID, 1000000.00, mainUser);
//        policyOne.getInsuredObjects().add(toyotaCar);
//        toyotaCar.getPolicies().add(policyOne);
//
//        userRepository.save(mainUser);
//        vehicleRepository.save(toyotaCar);
//        policyRepository.save(policyOne);
//
//        System.out.println("Starting...");
//        System.out.println("Policy status " + policyOne.getStatus());
//        System.out.println("Policy type " + policyOne.getPolicyType());
//        System.out.println("User count " + userRepository.count());
//
//    }
//}
