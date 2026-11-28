/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolemployeemanagement.model;

import java.util.ArrayList;

/**
 *
 * @author bayan
 */
public class EmployeeSearch {
    
    public static Employee binarySearch(ArrayList<Employee> list, String searchName,
                                        int left, int right){
        
        if (left > right){
            return null; 
        }
        
        int middle = left + (right - left) /2;
        Employee middleEmployee = list.get(middle); 
        int comparison = middleEmployee.getName().compareToIgnoreCase(searchName);
        
        if (comparison == 0){
            return middleEmployee; 
        }
        if (comparison > 0 ){
            return binarySearch (list, searchName, left, middle -1);
        }
        return binarySearch (list, searchName, middle + 1, right);
    }
}
