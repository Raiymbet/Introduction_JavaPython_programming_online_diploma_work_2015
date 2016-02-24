/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.dao;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import kz.model.Exercises;
import kz.model.Themes;

/**
 *
 * @author Raiymbet
 */
public interface ExercisesDAO {
    public List getAll() throws SQLException;
    
    public void create(Exercises exercise) throws SQLException;
    public void remove(Exercises exercise) throws SQLException;
    public void update(Exercises exercise) throws SQLException;
    
    public Exercises findByID(int exerciseID) throws SQLException;
    public List<Exercises> getExercisesByThemeID(int themeID) throws SQLException;
    public List<Exercises> findExercisesByString(String word) throws SQLException;
    
    public File getExerciseFile(Exercises exercise) throws SQLException;
        
    public void changeExercisesThemeID(Themes a1,Exercises b1) throws SQLException;
    
}
