/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.schoolemployeemanagement.enums;

/**
 *
 * @author bayan
 */
public enum MenuOptions {
    
    SORT(1),
    SEARCH(2),
    ADD_RECORDS(3),
    CREATE_BINARY_TREE(4),
    EXIT(5);
    
    private final int number;
    
    MenuOptions(int number){
        this.number = number;
    }
    
    public int getNumber(){ 
        return number;
    }
}
