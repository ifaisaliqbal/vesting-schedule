/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vesting.schedule;

import com.mycompany.vesting.schedule.services.VestingDataService;
import com.mycompany.vesting.schedule.csvReader.CsvReader;
import com.mycompany.vesting.schedule.models.AwardIdAndQuantity;
import com.mycompany.vesting.schedule.models.Employee;
import com.mycompany.vesting.schedule.models.VestingEvent;
import com.mycompany.vesting.schedule.utils.VestingEventsUtils;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author iqbal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException {
        String path = "C:\\Users\\iqbal\\Desktop\\vevent.csv";
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-05-01");
        VestingDataService dataSvc = new VestingDataService(path);
        List<VestingEvent> vestingEvents = dataSvc.getVestingData();
        List<VestingEvent> vestedOnOrBeforeDate = VestingEventsUtils.getEventsOnOrBeforeDate(vestingEvents, date);
        List<Employee> employees = VestingEventsUtils.parseVestingEvents(vestedOnOrBeforeDate);
        VestingEventsUtils.printEmployees(employees);
    }

}
