/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolemployeemanagement.controller;

import com.mycompany.schoolemployeemanagement.enums.MenuOptions;
import com.mycompany.schoolemployeemanagement.model.Employee;
import com.mycompany.schoolemployeemanagement.view.EmployeeView;
import com.mycompany.schoolemployeemanagement.enums.ManagerType;
import com.mycompany.schoolemployeemanagement.enums.Department;
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
        
        //Recursive Bonary Search
        private Employee binarySearch (
                         ArrayList<Employee> list,
                         String searchName,
                         int left,  
                         int right) {
              
            if (left > right){
                return null;
            }
            int middle = left + (right - left) /2;
            
            Employee middleEmployee = list.get(middle);
            
            int comparison = middleEmployee.getName().compareToIgnoreCase(searchName);
            
            if (comparison == 0) {
                return middleEmployee;
            }

            if (comparison > 0) {
                return binarySearch(
                        list, searchName, left, middle - 1);
            }

            return binarySearch(
                    list, searchName, middle + 1, right);
        }
            
        
        private void searchEmployees(){
            
            //Make sure the list is sorted before searching
            mergeSort(employees);
            
            view.displayMessage(" -- Search Employee -- ");
            
            String searchName = view.getInput("Enter employee full name: ").trim();
            
            if(searchName.isEmpty()){
                view.displayMessage("Name cannot be empty ");
                return;
            }
            
            Employee foundEmployee = binarySearch( employees, searchName, 0, employees.size()-1);
            
            if (foundEmployee != null){ 
                
                view.displayMessage( "-- Employee Found --" );
                view.displayMessage( "Name: " + foundEmployee.getName() );
                view.displayMessage( "Manager Type: " + foundEmployee.getManagerType());
                view.displayMessage( "Department: " + foundEmployee.getDepartment());
               
            
            } else{ 
                
                view.displayMessage("Employee not found");
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
       
        private void addEmployee(){
            
            view.displayMessage(" -- Add New Employee -- ");
            
            //Get employtee Name
            String name = view.getInput("Enter Employee Full Name:  " ).trim();
            
            if (name.isEmpty()){ 
                view.displayMessage("Name cannot be empty");
                return;
            }
           // Display available manager types
           ManagerType[] managerTypes = ManagerType.values(); 
           
           String[] managerTypeNames = new String [managerTypes.length];
           
           for (int i = 0; i < managerTypes.length; i++){
               managerTypeNames [i] = managerTypes[i].name().replace("_", " ");
           }
           
           view.displayManagerType(managerTypeNames); 
           
           String managerInput = view.getInput("Enter Manager Type: ").trim();
           
           ManagerType selectedManagerType;
           
           try{
               selectedManagerType = ManagerType.valueOf(managerInput.toUpperCase().replace(" ", "_"));
           
           } catch (IllegalArgumentException e){
               view.displayMessage("Invalid Manager Type. Employee was not added.");
               return;
           }
           // Display available departments
           Department [] departments = Department.values();
           
           String [] departmentNames = new String [departments.length];
           
           for (int i = 0; i < departments.length; i++){
               departmentNames[i] = departments[i].name().replace("_", " ");
           }
           
           view.displayDepartments(departmentNames);
           
           String departmentInput = view.getInput("Enter Depaartment: ").trim(); 
           
           Department selectedDepartment;
           
           try{ 
               selectedDepartment = Department.valueOf(departmentInput.toUpperCase().replace(" ", "_"));
          
           } catch (IllegalArgumentException e){
               
               view.displayMessage("Invalid Department. Employee was not added");
               return;
           }
           
           
           // Create and add employee 
           Employee newEmployee = new Employee(
            name,
            selectedManagerType.name().replace("_", " "),
            selectedDepartment.name().replace("_", " ")
           );
           
           employees.add(newEmployee);
           
           view.displayMessage(" -- Employee Successfuwlly added! -- ");
           view.displayMessage("Name: " + newEmployee.getName());
           view.displayMessage("Manager Type: " + newEmployee.getManagerType());
           view.displayMessage("Department: " + newEmployee.getDepartment());
           view.displayMessage("Total employees: " + employees.size());
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
                    searchEmployees();
                    break;

                case 3: 
                    view.displayMessage("Add New Records Selected");
                    addEmployee();
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
