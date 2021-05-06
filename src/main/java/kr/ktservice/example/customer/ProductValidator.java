package kr.ktservice.example.customer;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductValidator implements Validator {

    private static final String REQUIRED = "required";

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        String name = product.getProduct_name();
        // name validation
        if (!StringUtils.hasLength(name)) {
            errors.rejectValue("name", REQUIRED, REQUIRED);
        }

    }
}
