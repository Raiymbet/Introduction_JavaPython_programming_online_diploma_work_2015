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
import kz.model.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{
    
    private final SessionFactory sessionFactory;
    Session session;

    public UserDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    @Override
    public List getAllUsers() throws SQLException {
        session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Users.class);
        List users_list = cr.list();
        session.close();
        return users_list;
    }

    @Override
    public Users create(Users user) throws SQLException {
        session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(user);
        tr.commit();
        session.close();
        return user;
    }

    @Override
    public Users update(Users user) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users remove(Users user) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users authority(Users user) throws SQLException {
        session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Users.class);
        cr.add(Restrictions.eq("email", user.getEmail()).ignoreCase());
        cr.add(Restrictions.eq("password", user.getPassword()).ignoreCase());
        cr.setMaxResults(1);
        cr.setFirstResult(0);
        if (cr.list().isEmpty()) {
            session.close();
            return null;
        }else{        
            Users result_user = (Users) cr.list().get(0);
            System.out.println(cr.toString());
            session.close();
            return result_user;
        }        
    }

    @Override
    public Users findByID(int userId) throws SQLException {
        session = sessionFactory.openSession();
        Users user = (Users) session.get(Users.class,userId);
        if (user == null) {
                throw new NullPointerException("404!User not found by id");
            } else {    
                session.close();
                return user;
            }
    }

    @Override
    public Users findByEmail(String email) throws SQLException {
        session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Users.class);
        cr.add(Restrictions.eq("email", email));
        cr.uniqueResult();
        Users user = (Users) cr.list().get(0);
        if (user == null) {
                throw new NullPointerException("404!User not found by email");
            } else {    
                session.close();
                return user;
            }
    }
    
}
