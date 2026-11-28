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
public class EmployeeSorter {
    
    public static void mergeSort(ArrayList<Employee> list){ 
        
        if(list.size() <= 1){
            return;
        }
        
        int middle = list.size() / 2; 
        
        ArrayList<Employee> left = new ArrayList<>(list.subList(0, middle)); 
        ArrayList<Employee> right = new ArrayList<>(list.subList(middle, list.size())); 
        
        // Recursive Calls
        mergeSort(left);
        mergeSort(right);
        
        merge(list, left, right); 
    }
    
    private static void merge(ArrayList<Employee> list,
                              ArrayList<Employee> left,
                              ArrayList<Employee> right){ 
        
        int i = 0, j = 0, k = 0; 
        
         while (i < left.size() && j < right.size()) {
            if (left.get(i).getName().compareToIgnoreCase(right.get(j).getName()) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
        
        
    }
    
}
