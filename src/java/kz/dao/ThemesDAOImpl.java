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
import kz.hibernate.HibernateUtil;
import kz.model.Themes;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;

public class ThemesDAOImpl implements ThemesDAO {

    private Session session;
    
    @Override
    public List getAll() throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Themes.class);
        return cr.list();
    }

    @Override
    public Themes create(Themes theme) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Themes findByID(String themeID) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        Themes theme = (Themes) session.get(Themes.class, Integer.parseInt(themeID));
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
    
}
