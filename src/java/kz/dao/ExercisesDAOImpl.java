/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.dao;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import kz.hibernate.HibernateUtil;
import kz.model.Exercises;
import kz.model.Themes;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Raiymbet
 */
@Repository
public class ExercisesDAOImpl implements ExercisesDAO{

    private final SessionFactory sessionFactory;
    Session session;

    public ExercisesDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    
    @Override
    public List getAll() throws SQLException {
        session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Exercises.class);
        List exercises_list = cr.list();
        session.close();
        return exercises_list;
    }

    @Override
    public void create(Exercises exercise) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Exercises exercise) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Exercises exercise) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Exercises findByID(int exerciseID) throws SQLException {
        session = sessionFactory.openSession();
        Exercises exercise = (Exercises) session.get(Exercises.class, exerciseID);
        if (exercise == null) {
                throw new NullPointerException("404!Exercise not found by id");
            } else {    
                session.close();
                return exercise;
            }
    }

    @Override
    public List<Exercises> getExercisesByThemeID(int themeID) throws SQLException {
        session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Exercises.class).add(Restrictions.eq("ID_theme", themeID));
        List theme_exercises_list = cr.list();
        session.close();
        return theme_exercises_list;
    }
    
    @Override
    public List<Exercises> findExercisesByString(String word) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File getExerciseFile(Exercises exercise) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeExercisesThemeID(Themes a1, Exercises b1) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
