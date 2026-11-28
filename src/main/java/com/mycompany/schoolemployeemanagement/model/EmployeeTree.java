/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolemployeemanagement.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author bayan
 */
public class EmployeeTree {
    
    private EmployeeNode root;
    private int nodeCount = 0;

    public void insertLevelOrder(Employee employee) {

        EmployeeNode newNode = new EmployeeNode(employee);
        nodeCount++;

        // If the tree is empty, the new node becomes the root
        if (root == null) {
            root = newNode;
            return;
        }

        // Queue helps us visit nodes level by level, left to right
        Queue<EmployeeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            EmployeeNode current = queue.remove();

            // Check left child first
            if (current.getLeft() == null) {
                current.setLeft(newNode);
                return;
            } else {
                queue.add(current.getLeft());
            }

            // Then the right child
            if (current.getRight() == null) {
                current.setRight(newNode);
                return;
            } else {
                queue.add(current.getRight());
            }
        }
    }

    // Level-order traversal: one list of employees per level. 
    public ArrayList<ArrayList<Employee>> levelOrder() {

        ArrayList<ArrayList<Employee>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }

        Queue<EmployeeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();            // nodes on the current level
            ArrayList<Employee> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                EmployeeNode current = queue.remove();
                level.add(current.getEmployee());

                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
            levels.add(level);
        }
        return levels;
    }

    /** Height counted in LEVELS (a tree with only a root has height 1). */
    public int getHeight() {
        return treeHeight(root);
    }

    private int treeHeight(EmployeeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(treeHeight(node.getLeft()), treeHeight(node.getRight()));
    }

    public int getNodeCount() {
        return nodeCount;
    }
}
    

