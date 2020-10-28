package com.dsi.mapping;

import javax.persistence.*;

@Entity
@Embeddable
public class Temp {
    @Id
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
