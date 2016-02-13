package kz.model;
// Generated 04.02.2016 23:24:16 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Exersises generated by hbm2java
 */
@Entity
@Table(name="exersises"
    ,catalog="diploma_work"
)
public class Exersises  implements java.io.Serializable {


     private int id;
     private int idTheme;
     private String description;

    public Exersises() {
    }

    public Exersises(int id, int idTheme, String description) {
       this.id = id;
       this.idTheme = idTheme;
       this.description = description;
    }
   
     @Id 

    
    @Column(name="ID", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="ID_theme", nullable=false)
    public int getIdTheme() {
        return this.idTheme;
    }
    
    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    
    @Column(name="description", nullable=false, length=65535)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}


