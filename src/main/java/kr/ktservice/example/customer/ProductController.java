package kr.ktservice.example.customer;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/products/{productId}")
public class ProductController {

    private static final String VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductsForm";

    private final ProductRepository products;
    private final CustomerRepository customers;

    public ProductController(ProductRepository products, CustomerRepository customers) {
        this.products = products;
        this.customers = customers;
    }

    @ModelAttribute("types")
    public Collection<ProductType> populateProductTypes() {
        return this.products.findProductTypes();
    }

    @ModelAttribute("customer")
    public Customer findCustomer(@PathVariable("id") Long id) {
        return this.customers.findById(id);
    }

    @InitBinder("customer")
    public void initCustomerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @InitBinder("product")
    public void initProductBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new ProductValidator());
    }

}
