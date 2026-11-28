/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolemployeemanagement.model;

import java.io.IOException;
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.util.ArrayList;

/**
 *
 * @author bayan
 */
public class EmployeeFileLoader {
    
    public static ArrayList<Employee> load (String fileName) throws IOException{ 
        ArrayList<Employee> result = new ArrayList<>(); 
        
        for (String line : Files.readAllLines(Path.of(fileName))){ 
            
            if (line.trim().isEmpty()){
                continue; 
            }
            
            String [] data = line.split (",", -1 ); 
            
            // Each record should contain 9 columns
            if (data.length != 9 ){ 
                continue; 
            }
            
            // Skip the heading row if present
            if ( data[0].trim().equalsIgnoreCase("First Name")){
                continue;
            }
            
            String name = data[0].trim() + " " + data[1].trim();
            String managerType = data[6].trim();
            String department = data[5].trim();
            
            result.add(new Employee(name, managerType, department)); 
        }
        return result; 
    }
    
}
