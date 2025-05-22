package org.zowy;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvRecurse;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVTest1 {
    public static void main(String[] args) throws IOException, CsvValidationException {
        CSVReader reader = new CSVReader(new FileReader("travel.csv"));
        String [] line;
        while ((line = reader.readNext())!=null){
            String text = String.join(",",line);
            System.out.println(text);
        }
    }
}
