/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.controller;

import java.sql.SQLException;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import kz.dao.UserDAO;
import kz.dao.UserDAOImpl;
import kz.model.Users;
import kz.validator.LoginValidation;
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
public class LoginController{

    private final String SESSION_USER = "userSession";
    
    public LoginController() {
    }
    
    @RequestMapping(value="/login.htm", method = RequestMethod.GET)
    public ModelAndView loginview(Map<String, Object> model) throws SQLException{
        Users user = new Users();
        model.put("login", user);
        ModelAndView mv = new ModelAndView("login",model); 
        return mv;
    }
    
    @RequestMapping(value="/login.htm", method = RequestMethod.POST)
    public ModelAndView autenthication(@ModelAttribute("login") @Valid Users user, HttpSession session, BindingResult result) throws SQLException{
        //System.out.println(user.getEmail()+" "+user.getPassword());
        
        UserDAO userService = new UserDAOImpl();
        
        LoginValidation validator = new LoginValidation();
        validator.validate(user, result);
        
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView("login");
            return mv;
        }else{
            Users user_auth = userService.authority(user);
            if (user_auth != null) {
                session.setAttribute(SESSION_USER, user);
                ModelAndView mv = new ModelAndView("redirect:/index.htm");
                return mv;
            } else {
                ModelAndView mv = new ModelAndView("/error_pages/fail_login");
                return mv;
            }      
        }
         
    }
}
