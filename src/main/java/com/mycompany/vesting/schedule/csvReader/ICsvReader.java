/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vesting.schedule.csvReader;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author iqbal
 */
public interface ICsvReader<T> {
    public List<T> getExtractedRows();
    public void readCSV(Class c) throws IOException;
}
