/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolemployeemanagement.controller;

import com.mycompany.schoolemployeemanagement.enums.MenuOptions;
import com.mycompany.schoolemployeemanagement.model.Employee;
import com.mycompany.schoolemployeemanagement.view.EmployeeView;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author bayan
 */
public class EmployeeController {
    
    private ArrayList<Employee> employees;
    private EmployeeView view; 
    
    //Constructor
    public EmployeeController(){
        employees = new ArrayList<>();
        view = new EmployeeView(); 
    }
    
    // Reads Employee Records From the Text File
    private void loadEmployeesFromFile(){
        
        try{
            Path filePath = Path.of("Applicants_Form.txt");
            
            var lines = Files.readAllLines(filePath);
            
            for (String line : lines ){ 
                
                if (line.trim().isEmpty()){
                    continue;
                }
                
                String [] data = line.split(",", -1); 
                
                //Each record should contain 9 columns
                if(data.length !=9){
                    continue;
                }
                
                //Skip the heading row if present
                if (data[0].trim().equalsIgnoreCase("First Name")){
                continue;
            }
                String name = data[0].trim() + " " + data[1].trim();
                String managerType = data[6].trim();
                String department = data[5].trim(); 
                
                Employee employee = new Employee(name, managerType, department); 
                
                employees.add(employee);
            }
            
            view.displayMessage("File read successfully! Employee loaded: " + employees.size()); 
        } catch (IOException e){
            view.displayMessage(
            "Could not read Application_Form.txt. " + "Please check that the file is in the project folder");
        }
    }
        //Recursive Merge Sort
        private void mergeSort(ArrayList<Employee> list){
            
            if (list.size() <= 1){
                return;
            }   
        
        int middle = list.size() /2; 
        
        ArrayList<Employee> left = new ArrayList<>(
        list.subList(0, middle)); 
        
        ArrayList<Employee> right = new ArrayList<>(
        list.subList(middle, list.size())); 
        
        //Recursive Calls
        mergeSort(left);
        mergeSort(right);
        
        //Merge the sorted lists
        merge(list, left, right);
        }
        
        //Merge two sorted lists
        private void merge(
                ArrayList<Employee> list,
                ArrayList<Employee> left,
                ArrayList<Employee> right){
            
            int i = 0; 
            int j = 0;
            int k = 0; 
            
            while (i < left.size() && j < right.size()){
                
                if (left.get(i).getName().compareToIgnoreCase(
                        right.get(j).getName()) <= 0){
                    
                    list.set(k, left.get(i));
                    i++;
                    
                } else{ 
                    
                    list.set(k, right.get(j));
                    j++; 
                }
                
                k++;
            }
            
            while (i <left.size()){
                list.set(k,left.get(i));
                i++;
                k++;
            }
            
            while(j <right.size()){
                list.set(k, right.get(j));
                j++; 
                k++;
            }     
        }
        
        private void sortEmployees(){
            
            if(employees.isEmpty()){
                view.displayMessage("There are no employees to sort");
                return;
            }
            
            mergeSort(employees);
            
            view.displayMessage("Employees Sorted Alphabetically");
            view.displayMessage("-------------------------------");
            
            int displayNumber = Math.min(20, employees.size());
            
            for (int i = 0; i < displayNumber; i++){
                
                Employee employee = employees.get(i);
                System.out.println(
                        (i+1)+ "." +employee.getName()
                        + "| Position: " + employee.getManagerType()
                        + "| Department: " + employee.getDepartment());
            }
            
            view.displayMessage( 
            "Displayed " + displayNumber + " employees out of " + employees.size() + ".");
            
        }
    
    //Program Starting
    public void start(){
        
        loadEmployeesFromFile();
        
        boolean running = true;
        
        while (running){ 
            view.DisplayMenu();
            
            int choice = view.getMenuChoice();
            
            switch (choice){ 
            
                case 1: 
                    view.displayMessage("Sort Selected");
                    sortEmployees();
                    break;

                case 2: 
                    view.displayMessage("Search Selected");
                    break;

                case 3: 
                    view.displayMessage("Add New Records Selected");
                    break;

                case 4: 
                    view.displayMessage("Create A Binary Tree Selected");
                    break;

                case 5: 
                    view.displayMessage("Goodbye!");
                    running = false; 
                    break;

                default: 
                    view.displayMessage("Invalid choice. Please select 1 to 5.");
                    break;
            }    
        }
    }
}
