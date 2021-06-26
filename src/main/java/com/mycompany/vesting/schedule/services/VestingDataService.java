/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vesting.schedule.services;

import com.mycompany.vesting.schedule.csvReader.CsvReader;
import com.mycompany.vesting.schedule.models.VestingEvent;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author iqbal
 */
public class VestingDataService {

    private final CsvReader csvRdr;
    
    public VestingDataService(String path) {
        this.csvRdr = new CsvReader<VestingEvent>(path);
    }
    
    public List<VestingEvent> getVestingData() throws IOException {
        csvRdr.readCSV(VestingEvent.class);
        return (List<VestingEvent>) csvRdr.getExtractedRows();
    }
}
