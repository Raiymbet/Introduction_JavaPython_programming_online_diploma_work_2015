/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.controller;

import java.sql.SQLException;
import java.util.Map;
import javax.validation.Valid;
import kz.dao.UserDAO;
import kz.dao.UserDAOImpl;
import kz.model.Users;
import kz.validator.UserValidation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Raiymbet
 */
@Controller
public class RegistrationController {
    
    
    @RequestMapping(value = "/registration.htm", method = RequestMethod.GET)
    public ModelAndView register(Map<String, Object> model){
        Users user = new Users();
        model.put("user", user);
        ModelAndView mv = new ModelAndView("registration", model);
        return mv;
    }
    
    @RequestMapping(value = "/registration.htm", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("user") @Valid Users user, BindingResult result, Map<String, Object> model) throws SQLException{
        UserValidation validator = new UserValidation();
        validator.validate(user, result);
        
        if(result.hasErrors()){            
            ModelAndView mv = new ModelAndView("registration");
            return mv;
        }else{
            UserDAO userService = new UserDAOImpl();
            userService.create(user);
            ModelAndView mv = new ModelAndView("success");
            mv.addObject("user", user);
            mv.addObject("success", "You registrated successfully!");            
            return mv;
        }        
    }
    
    public boolean exists_user(String user){
        return true;
    }
    
}
