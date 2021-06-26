/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vesting.schedule.models;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import java.util.Date;
/**
 *
 * @author iqbal
 */
public class VestingEvent {
    @CsvBindByPosition(position = 0)
    private String operation;
    
    @CsvBindByPosition(position = 1)
    private String employeeId;
    
    @CsvBindByPosition(position = 2)
    private String name;
    
    @CsvBindByPosition(position = 3)
    private String awardId;
    
    @CsvDate(value = "yyyy-MM-dd")
    @CsvBindByPosition(position = 4)
    private Date date;
    
    @CsvBindByPosition(position = 5)
    private int quantity;
    
    public VestingEvent(){
        
    }

    public VestingEvent(String operation, String employeeId, String name, String awardId, Date date, int quantity) {
        this.operation = operation;
        this.employeeId = employeeId;
        this.name = name;
        this.awardId = awardId;
        this.date = date;
        this.quantity = quantity;
    }
    
    

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getAwardId() {
        return awardId;
    }

    public Date getDate() {
        return date;
    }

    public int getQuantity() {
        return quantity;
    }
}
