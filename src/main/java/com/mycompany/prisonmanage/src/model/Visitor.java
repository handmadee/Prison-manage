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
public class Visitor {
    private String name;
    private String relation;
    private String phone;
    private String date;
    public Visitor(String name, String relation, String phone, String date) {
        this.name = name;
        this.relation = relation;
        this.phone = phone;
        this.date = date;
    }
    public String getName() { return name; }
    public String getRelation() { return relation; }
    public String getPhone() { return phone; }
    public String getDate() { return date; }
}
