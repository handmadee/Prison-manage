/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prisonmanage.src.model;

/**
 *
 * @author admin
 */
public class Prisonal {
     private int id;
    private String name;
    private int age;
    private String crime;
    private String status;

    public Prisonal(int id, String name, int age, String crime, String status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.crime = crime;
        this.status = status;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCrime() { return crime; }
    public String getStatus() { return status; }
}
