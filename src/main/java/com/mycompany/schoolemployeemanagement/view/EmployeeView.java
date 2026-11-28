/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolemployeemanagement.view;

import java.util.Scanner;
/**
 *
 * @author bayan
 */
public class EmployeeView {
    
    private Scanner scanner = new Scanner (System.in);
    
    // Menu Display
    public void DisplayMenu(){
        
        System.out.println("-- School Employee Management --");
        System.out.println("1. Sort");
        System.out.println("2. Search");
        System.out.println("3. Add New Records");
        System.out.println("4. Create A Binary Tree");
        System.out.println("5. Exit");
        System.out.println("Please select an option: ");
    }
    
    public int getMenuChoice(){ 
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
    
    public void displayMessage(String message){
        System.out.println(message);   
    }
    
    public String getInput(String message){
        System.out.println(message);
        return scanner.nextLine();
    }
    
    public void displayManagerType(String[] types){
        System.out.println(" Available Manager types:");
        
        for (int i = 0; i < types.length; i++){
            System.out.println( (i + 1) + ". " + types[i]);
        }
    }
    
    public void displayDepartments(String[] departments){ 
        System.out.println("Available Departments:");
        
        for (int i = 0; i < departments.length; i++){ 
            System.out.println((i + 1 ) + ". " + departments[i]);
        }
    }
}
