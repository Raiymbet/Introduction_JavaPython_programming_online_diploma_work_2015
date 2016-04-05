/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
<<<<<<< HEAD
import javax.servlet.http.HttpServletRequest;
=======
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import kz.dao.ExercisesDAO;
import kz.dao.ExercisesDAOImpl;
>>>>>>> origin/master
import kz.dao.ThemesDAO;
import kz.dao.ThemesDAOImpl;
import kz.model.Themes;
import kz.service.DocumentReader;
<<<<<<< HEAD
=======
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
>>>>>>> origin/master

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
<<<<<<< HEAD
        path+="\\"+theme.getThemeDoc(); 
        System.out.println(path); 
        
        String content = DocumentReader.readDocxFile(path);
=======
        System.out.println(path); 
        String content = DocumentReader.readDocxFile(path+"/"+theme.getThemeDoc());
>>>>>>> origin/master
               
        List themeExercises = themeService.getThemeExercises(theme);
        
        mv.addObject("themes", themeService.getAll()); 
        mv.addObject("themeContent", theme);        
        mv.addObject("content", content);
        mv.addObject("exercises", themeExercises);
        return mv;
    }
    
<<<<<<< HEAD
=======
    @RequestMapping(value = "/tutorial/{themeId}/{exerciseId}/take_exercise.htm", method = RequestMethod.GET)
    public ModelAndView take_Exercise(@PathVariable("exerciseId") int exerciseId, @PathVariable("themeId") int themeId, HttpServletRequest request) throws SQLException, IOException{
        ModelAndView mv = new ModelAndView("take_exercise");        
        
        ExercisesDAO exerciseService = new ExercisesDAOImpl();
        Exercises exercise = exerciseService.findByID(exerciseId);
        
        List<Exercises> themeExercises = exerciseService.getExercisesByThemeID(themeId);
        
        String path = request.getSession().getServletContext().getRealPath("/resources/files/Example.java");
        System.out.println(path); 
        String code_example = DocumentReader.readCodeExample(path);
        
        mv.addObject("exercise", exercise);
        mv.addObject("themeExercises", themeExercises);
        mv.addObject("code", code_example);
        return mv;
    }
    
    @RequestMapping("/videolesson.htm")
    public String videolesson(){
        return "videolesson";
    }
    
>>>>>>> origin/master
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
