/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.dao;

/**
 *
 * @author Raiymbet
 */
import java.sql.SQLException;
import java.util.List;
import kz.model.Exercises;
import kz.model.Themes;

public interface ThemesDAO {
    public List getAll() throws SQLException;
    public Themes create(Themes theme) throws SQLException;
    public Themes remove(Themes theme) throws SQLException;
    public Themes update(Themes theme) throws SQLException;
    
    public Themes findByID(int themeID) throws SQLException;
    public Themes findByTheme(Themes theme) throws SQLException;
    public Themes getThemeDoc(Themes theme) throws SQLException;
    
    public List<Exercises> getThemeExercises(Themes theme) throws SQLException;
    
    public void changeExercisesThemeID(Themes a1,Exercises b1) throws SQLException;
    
    public List<Exercises> findExercisesByString(String word) throws SQLException;
    
    
}
