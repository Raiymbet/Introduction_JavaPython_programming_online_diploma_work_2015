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
import kz.model.Videos;
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
public class VideosDAOImpl implements VideosDAO{

    private final SessionFactory sessionFactory;
    Session session;
    
    public VideosDAOImpl(){
         this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    @Override
    public List getAll() throws SQLException {
        session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Videos.class);
        List videos_list = cr.list();
        session.close();
        return videos_list;
    }

    @Override
    public void create(Videos video) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Videos video) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Videos video) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Videos findByID(int videoID) throws SQLException {
        session = sessionFactory.openSession();
        Videos video = (Videos) session.get(Videos.class, videoID);
        if(video==null){
            throw new NullPointerException("404!Video not found by id");
        }else{
            session.close();
            return video;
        }
    }

    @Override
    public List<Videos> getVideosByThemeID(int themeID) throws SQLException {
        session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Videos.class).add(Restrictions.eq("ID_theme", themeID));
        List theme_videos_list = cr.list();
        session.close();
        return theme_videos_list;
    }

    @Override
    public List<Videos> findVideosByString(String word) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File getVideo(Videos video) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
