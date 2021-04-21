package kr.ktservice.example;

import kr.ktservice.example.customer.Customer;
import kr.ktservice.example.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CustomerRunner implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Customer customer = new Customer();
        customer.setCustomer_name("Custoner Name");
        customer.setCompany_name("Company Name");
        customer.setCreated(new Date());

        customerRepository.save(customer);

    }
}
