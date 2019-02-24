package ru.otus.agaryov.dz1.csvfilereader;

import java.util.LinkedHashMap;

public interface CsvFileReader {
    // Read csv file into a Map
    LinkedHashMap<String, String > readCsvIntoMap();
    // Where corrected strings are in config file?
    Integer getReadedStrsCount();
}
