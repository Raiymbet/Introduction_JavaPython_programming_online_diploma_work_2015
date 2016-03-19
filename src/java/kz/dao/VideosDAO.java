/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.dao;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import kz.model.Videos;

/**
 *
 * @author Raiymbet
 */
public interface VideosDAO {
     public List getAll() throws SQLException;
    
    public void create(Videos video) throws SQLException;
    public void remove(Videos video) throws SQLException;
    public void update(Videos video) throws SQLException;
    
    public Videos findByID(int videoID) throws SQLException;
    public List<Videos> getVideosByThemeID(int themeID) throws SQLException;
    public List<Videos> findVideosByString(String word) throws SQLException;
    
    public File getVideo(Videos video) throws SQLException;
}
