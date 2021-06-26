package com.mycompany.vesting.schedule.csvReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author iqbal
 * @param <T>
 */
public class CsvReader <T> implements ICsvReader{

    private final String path;
    private final List<T> extractedRows = new ArrayList<>();
    
    public CsvReader(String path) {
        this.path = path;
    }
    
    @Override
    public void readCSV(Class c) throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get(this.path));
        CsvToBean<T> csvToBean = new CsvToBeanBuilder(reader)
            .withType(c)
            .withIgnoreLeadingWhiteSpace(true)
            .build();
        
        Iterator<T> csvRowIterator = csvToBean.iterator();
        
        while(csvRowIterator.hasNext()) {
            T dataRow = csvRowIterator.next();
            extractedRows.add(dataRow);
        }
    }

    @Override
    public List<T> getExtractedRows() {
        return extractedRows;
    }
}
