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
import javax.script.ScriptException;
import kz.dao.ExercisesDAO;
import kz.dao.ExercisesDAOImpl;
import kz.model.Exercises;
import kz.service.CustomJavaCompiler;
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
    
  @RequestMapping(value = "/tutorial/{themeId}/{exerciseId}/take_exercise.htm", method = RequestMethod.POST)
  @ResponseBody
  public String run_code(ModelAndView model, @RequestParam(value = "code", required = true) String code) throws IOException, URISyntaxException, ScriptException{
      String code_result = CustomJavaCompiler.javaCompile("F:/NetBeansProjects/DiplomaProject/src/java/kz/service/Example.java");
      return code_result;
  }
    
}
