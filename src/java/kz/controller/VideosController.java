/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.controller;

import java.sql.SQLException;
import kz.dao.VideosDAO;
import kz.dao.VideosDAOImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Raiymbet
 */
@Controller
public class VideosController {
        
    @RequestMapping(value = "/videolesson.htm", method = RequestMethod.GET)
    public ModelAndView videolesson(Model model) throws SQLException{
        ModelAndView mv = new ModelAndView("videolesson");        
        VideosDAO all_videos = new VideosDAOImpl();   
        mv.addObject("videos", all_videos.getAll());   
        return mv;
    }
}
