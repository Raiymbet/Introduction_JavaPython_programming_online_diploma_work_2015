/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.validator;

import kz.model.Users;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Raiymbet
 */
@Component
public class UserValidation implements Validator{

    @Override
    public boolean supports(Class class_type) {
        return Users.class.isAssignableFrom(class_type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name", "Name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "error.surname","Surname is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email","Email is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password","Password is required");     
        
    }
    
}
