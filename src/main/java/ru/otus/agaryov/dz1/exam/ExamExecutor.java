package ru.otus.agaryov.dz1.exam;

import ru.otus.agaryov.dz1.csvfilereader.CsvFileReader;
import ru.otus.agaryov.dz1.results.ResultChecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.out;

public class ExamExecutor {
    private CsvFileReader csvFile;
    private ResultChecker checker;

    public ExamExecutor(CsvFileReader csvFileReader, ResultChecker resultChecker) {
        this.csvFile = csvFileReader;
        this.checker = resultChecker;
    }

    public void doExam() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        out.println("Введите Ваше Имя и фамилию:");
        String studentFIO = br.readLine();
        out.printf("Здравствуйте, %s!\n Вам предстоит ответить на %d вопр.\n Начнем!\n\n",
                studentFIO,csvFile.getReadedStrsCount());
        for (int i = 0; i < checker.getQuestions().length; i++) {
            String question = checker.getQuestions()[i].toString();
            out.printf("Вопрос %d: %s?\n > Ваш ответ:\n",i+1,question);
            String input = br.readLine();
            checker.checkAnswer(question,input);
        }
        out.printf("\nОК\nВы ответили правильно на %d вопр.\n",checker.getResult());
    }
}
