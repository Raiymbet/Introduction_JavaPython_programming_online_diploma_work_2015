/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Raiymbet
 */
@Entity
@Table(name="videos"
        ,catalog="diploma_work"
)
public class Videos implements java.io.Serializable{
    
    private int id;
    private int ID_theme;
    private String name;
    private String description;
    private String file;
    private String image;
    
    public Videos(){
    }
    
    public Videos(int id, int ID_theme, String name, String description, String file, String image){
        this.id = id;
        this.ID_theme = ID_theme;
        this.name = name;
        this.description = description;
        this.file = file;
        this.image = image;
    }

    @Id
    @Column(name="ID",nullable = false, unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the ID_theme
     */
    @Column(name = "ID_theme", nullable = false)
    public int getID_theme() {
        return ID_theme;
    }

    /**
     * @param ID_theme the ID_theme to set
     */
    public void setID_theme(int ID_theme) {
        this.ID_theme = ID_theme;
    }

    /**
     * @return the name
     */
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    @Column(name = "description", nullable = false, length = 500)
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the file
     */
    @Column(name = "file", nullable = false, length = 200)
    public String getFile() {
        return file;
    }

    /**
     * @param file the url to set
     */
    public void setFile(String url) {
        this.file = file;
    }

    /**
     * @return the image
     */
    @Column(name = "image", nullable = false, length = 200)
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }
}
