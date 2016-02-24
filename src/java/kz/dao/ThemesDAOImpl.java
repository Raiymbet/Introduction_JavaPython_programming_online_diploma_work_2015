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
import kz.hibernate.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import kz.model.Exercises;
import kz.model.Themes;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ThemesDAOImpl implements ThemesDAO {

    private final SessionFactory sessionFactory;

    public ThemesDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();    
    }
    
    @Override
    public List getAll() throws SQLException {
        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Themes.class);
        List themes_list = cr.list();              
        session.close();
        return themes_list;  
    }

    @Override
    public Themes create(Themes theme) throws SQLException {
        Session session = sessionFactory.openSession();
        session.persist(theme);
        session.close();
        return theme;
    }

    @Override
    public Themes remove(Themes theme) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Themes update(Themes theme) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Themes findByID(int themeID) throws SQLException {        
        Session session = sessionFactory.openSession();
        Themes theme = (Themes) session.get(Themes.class,themeID);
        if (theme == null) {
                throw new NullPointerException("404!Theme not found");
            } else {    
                session.close();
                return theme;
            }
    }

    @Override
    public Themes findByTheme(Themes theme) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Themes getThemeDoc(Themes theme) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Exercises> getThemeExercises(Themes theme) throws SQLException {        
        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Exercises.class).add(Restrictions.eq("ID_theme", theme.getId()));
        List exercises_list = cr.list();
        session.close();
        return exercises_list;
    }

    @Override
    public void changeExercisesThemeID(Themes a1, Exercises b1) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Exercises> findExercisesByString(String word) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
