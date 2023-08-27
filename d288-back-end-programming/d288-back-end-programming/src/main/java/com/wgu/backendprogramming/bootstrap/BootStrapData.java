package com.wgu.backendprogramming.bootstrap;

import com.wgu.backendprogramming.dao.CustomerRepository;
import com.wgu.backendprogramming.dao.DivisionRepository;
import com.wgu.backendprogramming.entities.Customer;
import com.wgu.backendprogramming.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {


    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        if (customerRepository.count() == 1) {Customer ironMan = new Customer();
            Customer captainAmerica = new Customer();
            Customer thor = new Customer();
            Customer theHulk = new Customer();
            Customer spiderMan = new Customer();

            Division newYork = divisionRepository.getReferenceById(31L);
            Division northernIreland = divisionRepository.getReferenceById(104L);

            ironMan.setFirstName("Tony");
            ironMan.setLastName("Stark");
            ironMan.setDivision(newYork);

            captainAmerica.setFirstName("Steve");
            captainAmerica.setLastName("Rogers");
            captainAmerica.setDivision(newYork);

            thor.setFirstName("Thor");
            thor.setLastName("Odinson");
            thor.setDivision(northernIreland);

            theHulk.setFirstName("Bruce");
            theHulk.setLastName("Banner");
            theHulk.setDivision(newYork);

            spiderMan.setFirstName("Peter");
            spiderMan.setLastName("Parker");
            spiderMan.setDivision(newYork);

            customerRepository.save(ironMan);
            customerRepository.save(captainAmerica);
            customerRepository.save(thor);
            customerRepository.save(theHulk);
            customerRepository.save(spiderMan);}
    }
}
