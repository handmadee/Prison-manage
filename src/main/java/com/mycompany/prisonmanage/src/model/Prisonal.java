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
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getCrime() { return crime; }
    public void setCrime(String crime) { this.crime = crime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
      @Override
    public String toString() {
        return "Prisonal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", crime='" + crime + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
    
}
