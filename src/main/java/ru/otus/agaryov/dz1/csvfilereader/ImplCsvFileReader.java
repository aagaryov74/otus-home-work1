package ru.otus.agaryov.dz1.csvfilereader;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import com.opencsv.CSVReader;

public class ImplCsvFileReader implements CsvFileReader {

    // Config File with questions
    private String csvFile;
    // Counter of strings that have been read
    private Integer readStrCounter;

    public ImplCsvFileReader(String fileName) {
        this.readStrCounter = 0;
        this.csvFile = fileName;
    }

    @Override
    public LinkedHashMap<String,String> readCsvIntoMap() {
        CSVReader reader;
        LinkedHashMap<String,String> qaMap = new LinkedHashMap<>();
        try {
            reader = new CSVReader(new FileReader(this.csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                    qaMap.put(line[0], line[1]);
                    //System.out.println("Q = "+ line[0] + ", A = "+ line[1]);
                    this.readStrCounter++;
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Error at reading " + csvFile + ": "
                    + e.toString());
        }
        return qaMap;
    }

    @Override
    public Integer getReadedStrsCount() {
        return readStrCounter;
    }

}
