/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.model;

import kz.model.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Raiymbet
 */
@Entity
@Table(name="books"
        ,catalog="diploma_work"
)
public class Books implements java.io.Serializable{
    
    private int id;
    private String name;
    private String description;
    private int avg_grade;
    private String file;    
    private String image;
    
    public Books(){
    }
    
    public Books(int id, String name, String description, int avg_grade, String file, String image){
        this.id = id;
        this.name = name;
        this.description = description;
        this.avg_grade = avg_grade;
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
     * @return the name
     */
    @Column(name = "name", nullable = false, length = 200)
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
    @Column(name = "description", nullable = false, length = 1000)
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

    /**
     * @return the avg_grade
     */
    @Column(name = "avg_grade", nullable = true)
    public int getAvg_grade() {
        return avg_grade;
    }

    /**
     * @param avg_grade the avg_grade to set
     */
    public void setAvg_grade(int avg_grade) {
        this.avg_grade = avg_grade;
    }
}
