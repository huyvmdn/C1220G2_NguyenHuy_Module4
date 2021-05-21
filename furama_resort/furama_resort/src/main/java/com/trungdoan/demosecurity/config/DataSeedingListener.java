package com.trungdoan.demosecurity.config;

import com.trungdoan.demosecurity.model.Role;
import com.trungdoan.demosecurity.model.User;
import com.trungdoan.demosecurity.model.entity.*;
import com.trungdoan.demosecurity.repository.*;
import com.trungdoan.demosecurity.ultil.EncrypPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * Seeding data test for table users and roles
 */
@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (roleRepository.findByName("ROLE_ADMIN") == null) {
            roleRepository.save(new Role("ROLE_ADMIN"));
        }

        if (roleRepository.findByName("ROLE_MEMBER") == null) {
            roleRepository.save(new Role("ROLE_MEMBER"));
        }
        if (roleRepository.findByName("ROLE_MEMBER") == null) {
            roleRepository.save(new Role("ROLE_BLOCK"));
        }

        //them admin
        if (userRepository.findByEmail("admin@gmail.com") == null) {
            User admin = new User();
            admin.setEmail("admin@gmail.com");
            admin.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_ADMIN"));
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            admin.setRoles(roles);
            userRepository.save(admin);
        }

        //Them Member
        if (userRepository.findByEmail("member@gmail.com") == null) {
            User user = new User();
            user.setEmail("member@gmail.com");
            user.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            user.setRoles(roles);
            userRepository.save(user);
        }
//        THEM CHUC VU

        if (positionRepository.findByName("Receptionist") == null) {
            positionRepository.save(new Position("Receptionist"));
        }
        if (positionRepository.findByName("Serve") == null) {
            positionRepository.save(new Position("Serve"));
        }

        if (positionRepository.findByName("Expert") == null) {
            positionRepository.save(new Position("Expert"));
        }
        if (positionRepository.findByName("Monitoring") == null) {
            positionRepository.save(new Position("Monitoring"));
        }

        if (positionRepository.findByName("Director") == null) {
            positionRepository.save(new Position("Director"));
        }
        if (positionRepository.findByName("Manager") == null) {
            positionRepository.save(new Position("manager"));
        }


//        LOAI KHACH HANG

        if (customerTypeRepository.findByName("Diamond") == null) {
            customerTypeRepository.save(new CustomerType("Diamond"));
        }
        if (customerTypeRepository.findByName("Platinium") == null) {
            customerTypeRepository.save(new CustomerType("Platinium"));
        }
        if (customerTypeRepository.findByName("Gold") == null) {
            customerTypeRepository.save(new CustomerType("Gold"));
        }
        if (customerTypeRepository.findByName("Silver") == null) {
            customerTypeRepository.save(new CustomerType("Silver"));
        }
        if (customerTypeRepository.findByName("Member") == null) {
            customerTypeRepository.save(new CustomerType("Member"));
        }


//        THEM BO PHAN


        if (divisionRepository.findByName("Sales – Marketing") == null) {
            divisionRepository.save(new Division("Sales – Marketing"));
        }
        if (divisionRepository.findByName("Administration") == null) {
            divisionRepository.save(new Division("Administration"));
        }
        if (divisionRepository.findByName("Service") == null) {
            divisionRepository.save(new Division("Service"));
        }

        if (divisionRepository.findByName("Management") == null) {
            divisionRepository.save(new Division("Management"));
        }

//        DICH VU DI KEM

        if (attachServiceRepository.findByName("car") == null) {
            attachServiceRepository.save(new AttachService("car", 200, 5, true));
        }
        if (attachServiceRepository.findByName("karaoke") == null) {
            attachServiceRepository.save(new AttachService("karaoke", 100, 5, true));
        }
        if (attachServiceRepository.findByName("Spa") == null) {
            attachServiceRepository.save(new AttachService("Spa", 50, 20, true));
        }
        if (attachServiceRepository.findByName("Motorcycle") == null) {
            attachServiceRepository.save(new AttachService("Motorcycle", 100, 10, true));
        }
        if (attachServiceRepository.findByName("Laundry") == null) {
            attachServiceRepository.save(new AttachService("Laundry", 10, 30, true));
        }
//        TRINH DO HOC VAN
//        Trung cấp, Cao đẳng, Đại học và sau đại học
        if (educationDegreeRepository.findByName("Intermediate") == null) {
            educationDegreeRepository.save(new EducationDegree("Intermediate"));
        }
        if (educationDegreeRepository.findByName("College") == null) {
            educationDegreeRepository.save(new EducationDegree("College"));
        }

        if (educationDegreeRepository.findByName("Undergraduate ") == null) {
            educationDegreeRepository.save(new EducationDegree("Undergraduate "));
        }
        if (educationDegreeRepository.findByName("Graduate") == null) {
            educationDegreeRepository.save(new EducationDegree("Graduate"));
        }

//         KIEU THUE
        if (rentTypeRepository.findByName("Year") == null) {
            rentTypeRepository.save(new RentType("Year"));
        }
        if (rentTypeRepository.findByName("Month") == null) {
            rentTypeRepository.save(new RentType("Month"));
        }
        if (rentTypeRepository.findByName("Day") == null) {
            rentTypeRepository.save(new RentType("Day"));
        }
        if (rentTypeRepository.findByName("Hours") == null) {
            rentTypeRepository.save(new RentType("Hours"));
        }


//        KIEU SERVICE
        if (serviceTypeRepository.findByName("Villa") == null) {
            serviceTypeRepository.save(new ServiceType("Villa"));
        }

        if (serviceTypeRepository.findByName("House") == null) {
            serviceTypeRepository.save(new ServiceType("House"));
        }

        if (serviceTypeRepository.findByName("Room") == null) {
            serviceTypeRepository.save(new ServiceType("Room"));
        }
    }

}



