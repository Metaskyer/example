package kr.ktservice.example.controller;

import kr.ktservice.example.customer.Customer;
import kr.ktservice.example.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @GetMapping("/customerForm")
    public String customerForm(Model model, @RequestParam(required = false) Long id) {
        if(id == null) {
            model.addAttribute("customer", new Customer());
        } else {
            Customer customer = customerRepository.findById(id).orElse(null);
            model.addAttribute("customer", customer);
        }

        return "customer/customerForm";
    }

    @PostMapping("/customerForm")
    public String customerSubmit(@ModelAttribute Customer customer) {
        customer.setCreated(new Date());
        customerRepository.save(customer);
        return "redirect:/customer/list";
    }

}
