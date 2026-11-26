/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolemployeemanagement.model;

/**
 *
 * @author bayan
 */
public class Employee {
    
    // Employee information
    private String name; 
    private String managerType;
    private String department; 
    
    //Constructor 
    public Employee(String name, String managerType, String department){
        this.name = name; 
        this.managerType = managerType; 
        this.department = department; 
    }

    // Get Employee name
    public String getName() {
        return name;
    }

    public String getManagerType() {
        return managerType;
    }

    // Get department 
    public String getDepartment() {
        return department;
    }
    
    
}
