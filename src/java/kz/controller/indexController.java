/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kz.dao.ThemesDAO;
import kz.dao.ThemesDAOImpl;
import kz.model.Themes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Raiymbet
 */
@Controller
public class indexController {
    indexController indexController;
    public indexController() {
    }
    
    public indexController(indexController indexController) {
        this.indexController = indexController;
    }
    
    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public ModelAndView index(Model model) throws SQLException{
        ModelAndView mv = new ModelAndView("index");        
        ThemesDAO all_themes = new ThemesDAOImpl();   
        mv.addObject("themes", all_themes.getAll());   
        return mv;
    }
    
    @RequestMapping(value = "/index/{id}/tutorial.htm", method = RequestMethod.GET)
    public ModelAndView getThemeContent(@PathVariable(value = "id") Integer id) throws SQLException{
        ModelAndView mv = new ModelAndView("tutorial");
        ThemesDAO theme_modul = new ThemesDAOImpl();
        Themes theme = theme_modul.findByID(id.toString());
        mv.addObject("themeContent", theme);
        mv.addObject("themes", theme_modul.getAll());
        return mv;
    }
    
    @RequestMapping("/login.htm")
    public String login(Model model){
        return "login";
    }
    
    @RequestMapping("/registration.htm")
    public String register(){
        return "registration";
    }
    
    @RequestMapping("/videolesson.htm")
    public String videolesson(){
        return "videolesson";
    }
    
    @RequestMapping("/library.htm")
    public String library(){
        return "library";
    }
    
    @RequestMapping("/exercise.htm")
    public String exercise(){
        return "exercise";
    }
    
    @RequestMapping("/faq.htm")
    public String faq(){
        return "faq";
    }
}
