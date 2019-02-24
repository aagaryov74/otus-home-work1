package ru.otus.agaryov.dz1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.agaryov.dz1.csvfilereader.CsvFileReader;
import ru.otus.agaryov.dz1.exam.ExamExecutor;
import ru.otus.agaryov.dz1.results.ResultChecker;
import ru.otus.agaryov.dz1.results.ImplResultChecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        CsvFileReader csvFile = context.getBean(CsvFileReader.class);
        ResultChecker checker = context.getBean(ImplResultChecker.class);
        ExamExecutor executor = context.getBean(ExamExecutor.class);
        if (csvFile.getReadedStrsCount() > 0) {
            try {
                executor.doExam();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            out.println("Sorry but you cannot continue due errors with config");
        }


    }
}
