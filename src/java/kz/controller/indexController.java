/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import kz.dao.ThemesDAO;
import kz.dao.ThemesDAOImpl;
import kz.model.Themes;
import kz.service.DocumentReader;

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
    
//    @Autowired(required = true)
//    ThemesDAOImpl themes_service;
//    @Autowired(required = true)
//    ExercisesDAOImpl exercises_service;
    
    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public ModelAndView index(Model model) throws SQLException{
        ModelAndView mv = new ModelAndView("index");        
        ThemesDAO all_themes = new ThemesDAOImpl();   
        mv.addObject("themes", all_themes.getAll());   
        return mv;
    }
    
    @RequestMapping(value = "/index/{themeId}/tutorial.htm", method = RequestMethod.GET)
    public ModelAndView getThemeContent(@PathVariable("themeId") Integer id, HttpServletRequest request) throws SQLException, IOException{
        ModelAndView mv = new ModelAndView("tutorial");
                       
        ThemesDAO themeService = new ThemesDAOImpl(); 
        Themes theme = themeService.findByID(id);
        
        String path = request.getSession().getServletContext().getRealPath("/resources/tutorial_doc/");
        path+="\\"+theme.getThemeDoc(); 
        System.out.println(path); 
        
        String content = DocumentReader.readDocxFile(path);
               
        List themeExercises = themeService.getThemeExercises(theme);
        
        mv.addObject("themes", themeService.getAll()); 
        mv.addObject("themeContent", theme);        
        mv.addObject("content", content);
        mv.addObject("exercises", themeExercises);
        return mv;
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
