package com.dsi.compositeKey;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cmposite_key")
public class User {
    private int id;
    private String name;
    private String hus;
    
}
