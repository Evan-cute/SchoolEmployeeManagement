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
        return scanner.nextInt();
    }
    
    public void displayMessage(String message){
        System.out.println(message);   
    }
    
    public String getInput(String message){
        System.out.println(message);
        return scanner.nextLine();
    }
}
