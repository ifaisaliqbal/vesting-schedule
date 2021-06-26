/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vesting.schedule.models;

import java.util.Date;

/**
 *
 * @author iqbal
 */
public class AwardIdAndQuantity {
    //type: vest or delete
    //quantity
    //date
    private String awardId;
    private String transactionType;
    private Date date;
    private int quantity;
    
    public AwardIdAndQuantity(String awardId, String transactionType, Date date, int quantity) {
        this.awardId = awardId;
        this.transactionType = transactionType;
        this.date = date;
        this.quantity = quantity;
    }
    
    

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
