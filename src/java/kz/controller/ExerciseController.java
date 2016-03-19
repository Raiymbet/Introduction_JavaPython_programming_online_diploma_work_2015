/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import kz.dao.ExercisesDAO;
import kz.dao.ExercisesDAOImpl;
import kz.model.Exercises;
import kz.service.CustomJavaCompiler;
import kz.service.DocumentReader;
import kz.service.JavaRunner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Raiymbet
 */
@Controller
public class ExerciseController {
    
    @RequestMapping(value = "/tutorial/{themeId}/{exerciseId}/take_exercise.htm", method = RequestMethod.GET)
    public ModelAndView take_Exercise(@PathVariable("exerciseId") int exerciseId, @PathVariable("themeId") int themeId, HttpServletRequest request) throws SQLException, IOException{
        ModelAndView mv = new ModelAndView("take_exercise");        
        
        ExercisesDAO exerciseService = new ExercisesDAOImpl();
        Exercises exercise = exerciseService.findByID(exerciseId);
        
        List<Exercises> themeExercises = exerciseService.getExercisesByThemeID(themeId);
        
        String path = request.getSession().getServletContext().getRealPath("/resources/files/");
        path += "\\Example.java";
        System.out.println(path); 
        
        String code_example = DocumentReader.readCodeExample(path);
        
        mv.addObject("exercise", exercise);
        mv.addObject("themeExercises", themeExercises);
        mv.addObject("code", code_example);
        return mv;
    }
    
    @RequestMapping(value = "/tutorial/{themeId}/{exerciseId}/take_exercise.htm", method = RequestMethod.POST)
    @ResponseBody
    public String run_code(ModelAndView model, @RequestParam(value = "code", required = true) String code, HttpServletRequest request) throws IOException, URISyntaxException, ScriptException{
        String path = request.getSession().getServletContext().getRealPath("/resources/files/Example.java");
        System.out.println("Run path: "+path);
        DocumentReader.writeCodeToFile(path, code);
        String code_result = CustomJavaCompiler.javaCompile(path);
        if("Task is called and compilation is completed!".equals(code_result)){
            try {
                String run_result = JavaRunner.runProcess("java Example",request.getSession().getServletContext().getRealPath("/resources/files"));
                return run_result;
            } catch (Exception ex) {
                Logger.getLogger(ExerciseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return code_result;
  }
    
}
