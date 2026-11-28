/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolemployeemanagement.model;

import com.mycompany.schoolemployeemanagement.enums.Department;
import com.mycompany.schoolemployeemanagement.enums.ManagerType;

/**
 *
 * @author bayan
 */
public class EmployeeValidator {
    
    // A name must start with a letter and contain only letters, spaces, hyphens or apostrophes
    public static boolean isValidName(String name){ 
        return name != null && name.matches("[A-Za-z][A-Za-z '\\-]*");
    }
    
    // Returns the ManagerType, or null if it does not exist
    public static ManagerType parseManagerType(String input) {
        return parseEnum(ManagerType.class, input);
    }

    // Returns the Department, or null if it does not exist
    public static Department parseDepartment(String input) {
        return parseEnum(Department.class, input);
    }

    // Accepts a list number or the enum name, for example:  "assistant manager"
    private static <E extends Enum<E>> E parseEnum(Class<E> type, String input) {
        E[] values = type.getEnumConstants();
        try {
            int number = Integer.parseInt(input.trim());
            return (number >= 1 && number <= values.length) ? values[number - 1] : null;
        } catch (NumberFormatException e) {
            // not a number, so try matching by name
        }
        for (E value : values) {
            if (value.name().equalsIgnoreCase(input.trim().replace(" ", "_"))) {
                return value;
            }
        }
        return null;
    }
    
}
