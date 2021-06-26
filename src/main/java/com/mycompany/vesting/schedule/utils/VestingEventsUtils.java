/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vesting.schedule.utils;

import com.mycompany.vesting.schedule.models.AwardIdAndQuantity;
import com.mycompany.vesting.schedule.models.Employee;
import com.mycompany.vesting.schedule.models.VestingEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author iqbal
 */
public class VestingEventsUtils {

    enum vestingOperationTypes {
        VEST, CANCEL
    }

    public static List<VestingEvent> getEventsOnOrBeforeDate(List<VestingEvent> vEvents, Date date) {

        return vEvents.stream().filter(item -> ((VestingEvent) item).getDate() != null).map(item -> {
            if (((VestingEvent) item).getDate().compareTo(date) > 0) {
                item.setQuantity(0);
            }
            return item;
        }).collect(Collectors.toList());
    }

    public static List<Employee> parseVestingEvents(List<VestingEvent> vestedOnOrBeforeDate) {

        List<Employee> employees = new ArrayList<>();

        vestedOnOrBeforeDate.forEach(vEvent -> {
            Employee emp = employees.stream()
                    .filter(item -> item.getEmployeeId() != null && !item.getEmployeeId().isEmpty())
                    .filter(item -> item.getEmployeeId().equals(vEvent.getEmployeeId())).findFirst().orElse(null);

            AwardIdAndQuantity award = new AwardIdAndQuantity(vEvent.getAwardId(), vEvent.getOperation(),
                    vEvent.getDate(), vEvent.getQuantity());

            if (emp == null) {
                ArrayList<AwardIdAndQuantity> awardArray = new ArrayList<>();
                awardArray.add(award);

                employees.add(new Employee(vEvent.getName(), vEvent.getEmployeeId(), awardArray));
            } else {
                AwardIdAndQuantity existingAwardArray = emp.getAwardsAndQuantity().stream()
                        .filter(item -> item.getAwardId().equals(vEvent.getAwardId())).findFirst().orElse(null);

                if (existingAwardArray == null) {
                    emp.getAwardsAndQuantity().add(award);
                } else {
                    int qty = existingAwardArray.getQuantity();
                    existingAwardArray.setQuantity(
                            (vEvent.getOperation().toUpperCase().equals(vestingOperationTypes.CANCEL.toString())
                                    ? -vEvent.getQuantity()
                                    : vEvent.getQuantity()) + qty);
                }
            }
        });
        return employees;
    }

    public static void printEmployees(List<Employee> employees) {
        employees.forEach(ee -> {
            ee.getAwardsAndQuantity().stream().map(aa -> String.format("%s,%s,%s,%s", ee.getEmployeeId(), ee.getName(),
                    aa.getAwardId(), aa.getQuantity())).forEachOrdered(output -> {
                        System.out.println(output);
                    });
        });
    }
}