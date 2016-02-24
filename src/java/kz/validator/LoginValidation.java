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
public class LoginValidation implements Validator {

    @Override
    public boolean supports(Class class_type) {
        return Users.class.isAssignableFrom(class_type);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email","Email is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password","Password is required");     
        
        Users user = (Users) obj;
        if(user.getPassword().length()<6){
            errors.rejectValue("password","error.password","Password length must be greater than 6");
        }
    }
    
}
