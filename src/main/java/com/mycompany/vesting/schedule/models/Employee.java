/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vesting.schedule.models;

import java.util.ArrayList;

/**
 *
 * @author iqbal
 */
public class Employee {
    private String name;
    private String employeeId;
    private ArrayList<AwardIdAndQuantity> awardsAndQuantity;
    
        public Employee(String name, String employeeId, ArrayList<AwardIdAndQuantity> awardsAndQuantity) {
        this.name = name;
        this.employeeId = employeeId;
        this.awardsAndQuantity = awardsAndQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public ArrayList<AwardIdAndQuantity> getAwardsAndQuantity() {
        return awardsAndQuantity;
    }

    public void setAwardsAndQuantity(ArrayList<AwardIdAndQuantity> awardsAndQuantity) {
        this.awardsAndQuantity = awardsAndQuantity;
    }
}
