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
import kz.model.Users;

public interface UserDAO {
    public List getAllUsers() throws SQLException;
    public Users create(Users user) throws SQLException;
    public Users update(Users user) throws SQLException;
    public Users remove(Users user) throws SQLException;
    
    public Users authority(Users user) throws SQLException;
    public Users findByID(int ID) throws SQLException;
    public Users findByEmail(String email) throws SQLException;
}
