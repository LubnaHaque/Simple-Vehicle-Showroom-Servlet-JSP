package com.dsi.mapping;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "Temp_name" , referencedColumnName = "name")
    private Temp temp;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", temp=" + temp +
                '}';
    }
}
