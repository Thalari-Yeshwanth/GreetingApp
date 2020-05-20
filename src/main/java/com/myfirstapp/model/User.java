package com.myfirstapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="Users")
public class User {

    private String firstName;
    private String lastName;
    @Id

    private  long id;

    public User() {
        this.firstName = "";
        this.lastName = "";
        this.id = 0;
    }

    public User(String firstName, String lastName, long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String name) {
        firstName = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setId(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
            String str = (firstName!=null)?firstName + " ": "";
        str += (lastName!=null) ? lastName : "";
        return  str.trim();
    }
}
