package com.dsi.mapping;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public  void main(String[] args) {
        Session session = HibernateUtil2.getSessionFactory().openSession();
        session.beginTransaction();

        Temp temp = new Temp();
        temp.setName("Haque");

        Course course = new Course();
        course.setTitle("Math");
        course.setTemp(temp);

        session.save(course);

        session.getTransaction().commit();
    }
}
